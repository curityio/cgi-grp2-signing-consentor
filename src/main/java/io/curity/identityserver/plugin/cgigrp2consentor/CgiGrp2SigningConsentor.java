/*
 *  Copyright 2019 Curity AB
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package io.curity.identityserver.plugin.cgigrp2consentor;

import com.google.common.collect.ImmutableMap;
import com.grp.service.v2_0.types.CollectResponseType;
import com.grp.service.v2_0.types.OrderResponseType;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.curity.identityserver.sdk.attribute.Attribute;
import se.curity.identityserver.sdk.attribute.Attributes;
import se.curity.identityserver.sdk.errors.ErrorCode;
import se.curity.identityserver.sdk.oauth.consent.ConsentorResultAttributes;
import se.curity.identityserver.sdk.oauth.consent.SigningConsentorResult;
import se.curity.identityserver.sdk.oauth.consent.signing.SigningConsentor;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.SessionManager;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;

import static se.curity.identityserver.sdk.web.ResponseModel.templateResponseModel;

public class CgiGrp2SigningConsentor implements SigningConsentor
{
    private static final Logger _logger = LoggerFactory.getLogger(CgiGrp2SigningConsentor.class);

    private static final String CONSENT_ORDER_REF = "_consentOrderRef";
    private static final String OCSP = "OCSP";
    private static final String NAME = "Name";
    private static final String PERSONAL_NUMBER = "PersonalNumber";
    private static final String SIGNATURE = "Signature";
    private static final String VISIBLE_SIGNING_DATA = "_visibleSigningData";
    private static final String PROVIDER_IS_BANK_ID = "providerIsBankID";
    private static final String AUTOSTART_TOKEN = "_autostartToken";
    private static final String QR_CODE = "_qrCode";
    private static final String DATA_IMAGE_PNG_BASE_64 = "data:image/png;base64,";
    private static final String EMPTY_STRING = "";

    private final ExceptionFactory _exceptionFactory;
    private final CgiGrp2SigningClient _signingClient;
    private final SessionManager _sessionManager;
    private final boolean _providerIsBankId;

    /**
     * Key for the name of the value that would override the default 'img-src' definition
     * in the Content Security Policy header. When used, must include complete
     * definition, for example "img-src 'self' data:;'
     */
    private static final String CSP_OVERRIDE_IMG_SRC = "_cspImgsrc";
    private static final String CSP_OVERRIDE_IMG_SRC_DATA = "img-src 'self' data:;";
    /**
     * Key for the name of the value that would override the default 'child-src' definition
     * in the Content Security Policy header. When used, must include complete
     * definition, for example "child-src 'self' bankid:;'
     */
    private static final String CSP_OVERRIDE_CHILD_SRC = "_cspChildSrc";
    private static final String POLLER = "grpv2-poller";
    private static final String COMPLETE = "COMPLETE";
    private static final String USER_CANCEL = "USER_CANCEL";

    public CgiGrp2SigningConsentor(CgiGrp2ConsentorConfiguration configuration)
    {
        _exceptionFactory = configuration.getExceptionFactory();
        _signingClient = new CgiGrp2SigningClient(_exceptionFactory,
                configuration.operationalMode(),
                configuration.authenticationMode(),
                configuration.serviceId(),
                AuthenticationProvider.bankid,
                configuration.getTrustManagerFactory());
        _sessionManager = configuration.getSessionManager();
        _providerIsBankId = true;
    }

    @Override
    public SigningConsentorResult start(String textToDisplay, String objectToSign)
    {
        OrderResponseType response = _signingClient.sign(textToDisplay, objectToSign);

        buildResponseFormData(response, textToDisplay);

        Map<String, Object> responseParameters =
                buildResponseFormData(response, textToDisplay);

        return SigningConsentorResult.pending(templateResponseModel(responseParameters, POLLER));
    }

    @Override
    public SigningConsentorResult poll()
    {
        String orderRef = Optional.ofNullable(_sessionManager.get(CONSENT_ORDER_REF))
                .flatMap(attributeValues -> Optional.ofNullable(attributeValues.getAttributeValue()))
                .flatMap(value -> Optional.ofNullable(value.getValue())).orElse("").toString();

        CollectResponseType response = _signingClient.collect(orderRef);

        if (COMPLETE.equalsIgnoreCase(response.getProgressStatus()))
        {
            ImmutableMap<String, Object> grpResponseMap = new ImmutableMap.Builder<String, Object>()
                    .put(OCSP, response.getValidationInfo().getOcspResponse())
                    .put(NAME, response.getUserInfo().getDisplayName())
                    .put(PERSONAL_NUMBER, response.getUserInfo().getSubjectIdentifier())
                    .put(SIGNATURE, response.getValidationInfo().getSignature())
                    .build();

            ConsentorResultAttributes consentorResult =
                    ConsentorResultAttributes.of(Attributes.fromMap(grpResponseMap));

            _logger.trace("Response from CGI-GRP {}", grpResponseMap);

            return SigningConsentorResult.success(consentorResult);
        }

        if (USER_CANCEL.equalsIgnoreCase(response.getProgressStatus()))
        {
            return SigningConsentorResult.unsuccessfulResult(USER_CANCEL, ErrorCode.USER_ABORTED_OPERATION);
        }

        return SigningConsentorResult.pendingUserCompletion();
    }

    @Override
    public void cancel()
    {
        String orderRef = Optional.ofNullable(_sessionManager.get(CONSENT_ORDER_REF))
                .flatMap(attributeValues -> Optional.ofNullable(attributeValues.getAttributeValue()))
                .flatMap(value -> Optional.ofNullable(value.getValue())).orElse(EMPTY_STRING).toString();

        _signingClient.cancel(orderRef);

        _logger.trace("CGI-GRP cancellation was successful");
    }

    private Map<String, Object> buildResponseFormData(OrderResponseType response, String textToDisplay)
    {
        _sessionManager.put(Attribute.of(CONSENT_ORDER_REF, response.getOrderRef()));

        String autoStartToken = response.getAutoStartToken();

        return new ImmutableMap.Builder<String, Object>()
                .put(QR_CODE, generateQRCodeAsDataUri("bankid:///?autostarttoken=" + autoStartToken))
                .put(AUTOSTART_TOKEN, autoStartToken)
                .put(VISIBLE_SIGNING_DATA, textToDisplay)
                .put(PROVIDER_IS_BANK_ID, _providerIsBankId)
                .put(CSP_OVERRIDE_CHILD_SRC, "child-src 'self' " + "bankid" + ":;")
                .put(CSP_OVERRIDE_IMG_SRC, CSP_OVERRIDE_IMG_SRC_DATA).build();
    }

    private static String generateQRCodeAsDataUri(String value)
    {
        StringBuilder builder = new StringBuilder(DATA_IMAGE_PNG_BASE_64);
        ByteArrayOutputStream stream = QRCode.from(value)
                .to(ImageType.PNG)
                .withSize(250, 250)
                .stream();

        String base64EncodedData = Base64.getEncoder().encodeToString(stream.toByteArray());

        builder.append(base64EncodedData);

        return builder.toString();
    }
}
