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

import com.grp.service.v2_0.GrpFault;
import com.grp.service.v2_0.GrpService;
import com.grp.service.v2_0.GrpServicePortType;
//import com.grp.service.v2_0.types.CancelRequestType;
import com.grp.service.v2_0.types.CancelResponseType;
import com.grp.service.v2_0.types.CollectRequestType;
import com.grp.service.v2_0.types.CollectResponseType;
import com.grp.service.v2_0.types.GrpFaultType;
import com.grp.service.v2_0.types.OrderResponseType;
import com.grp.service.v2_0.types.SignRequestType;
import se.curity.identityserver.sdk.service.ExceptionFactory;
import se.curity.identityserver.sdk.service.trust.TrustManagerFactory;

import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.xml.ws.BindingProvider;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.StringJoiner;

/**
 * Concrete implementation for calling the CGI-GRP2 API.
 */
public class CgiGrp2SigningClient
{
    private static final String USER_CANCEL = "USER_CANCEL";
    private static final String DOMAIN_NAME_COULD_NOT_BE_PARSED = "Domain name for CGI-GRP endpoint could not be parsed";

    private ExceptionFactory _exceptionFactory;
    private GRPOperationalMode _operationalMode;
    private GRPAuthenticationMode _authenticationMode;
    private String _serviceId;
    private ServiceProvider _serviceProvider;
    private TrustManagerFactory _trustManagerFactory;

    private static final String EID_TEST_ENDPOINT = "https://eidt.funktionstjanster.se:18898/grp/v2";
    private static final String GRP_TEST_ENDPOINT = "https://grpt.funktionstjanster.se:18898/grp/v2";
    private static final String EID_PROD_ENDPOINT = "https://eid.funktionstjanster.se:8890/grp/v2";
    private static final String GRP_PROD_ENDPOINT = "https://grp.funktionstjanster.se:8890/grp/v2";

    public CgiGrp2SigningClient(ExceptionFactory exceptionFactory,
                                GRPOperationalMode operationalMode,
                                GRPAuthenticationMode authenticationMode,
                                String serviceId,
                                ServiceProvider serviceProvider,
                                TrustManagerFactory trustManagerFactory)
    {
        _exceptionFactory = exceptionFactory;
        _authenticationMode = authenticationMode;
        _operationalMode = operationalMode;
        _serviceId = serviceId;
        _serviceProvider = serviceProvider;
        _trustManagerFactory = trustManagerFactory;
    }

    public OrderResponseType sign(String textToDisplay, String objectToSign)
    {
        SignRequestType signRequest = new SignRequestType();
        OrderResponseType response;
        try
        {
            signRequest.setPolicy(_serviceId);
            signRequest.setProvider(_serviceProvider.name());
            signRequest.setUserVisibleData(Base64.getEncoder().encodeToString(textToDisplay.getBytes(StandardCharsets.UTF_8)));
            signRequest.setUserNonVisibleData(Base64.getEncoder().encodeToString(objectToSign.getBytes(StandardCharsets.UTF_8)));

            response = getServicePort().sign(signRequest);
        }
        catch (GrpFault grpFault)
        {
            throw _exceptionFactory.externalServiceException(extractErrorMessage(grpFault));
        }

        return response;
    }

    public CollectResponseType collect(String orderRef)
    {
        CollectResponseType response = new CollectResponseType();
        CollectRequestType collectRequest = new CollectRequestType();
        collectRequest.setOrderRef(orderRef);
        collectRequest.setPolicy(_serviceId);
        collectRequest.setProvider(_serviceProvider.name());

        try
        {
            response = getServicePort().collect(collectRequest);
        }
        catch (GrpFault grpFault)
        {
            // when a user cancels via the native application then a GrpFault is returned.
            if (USER_CANCEL.equalsIgnoreCase(grpFault.getMessage()))
            {
                response.setProgressStatus(USER_CANCEL);
                return response;
            }

            throw _exceptionFactory.externalServiceException(extractErrorMessage(grpFault));
        }

        return response;
    }

    public CancelResponseType cancel(String orderRef)
    {

        // The cancel() method is not yet implemented from CGI.
        // If the following block is commented out, the call to cancel() will throw an error.
        // INTERNAL_ERROR Message: Method not implemented

        //CancelResponseType cancelResponse = new CancelResponseType();
        //try
        //{
        // CancelRequestType cancelRequest = new CancelRequestType();
        // cancelRequest.setOrderRef(orderRef);
        // cancelRequest.setProvider(_serviceProvider.name());
        // cancelRequest.setPolicy(_serviceId);
        // cancelResponse = getServicePort().cancel(cancelRequest);
        //}
        //catch (GrpFault grpFault)
        //{
        //            throw _exceptionFactory.externalServiceException(extractErrorMessage(grpFault));
        //      }

        return new CancelResponseType();
    }

    private GrpServicePortType getServicePort()
    {
        GrpService service = new GrpService();
        GrpServicePortType port = service.getGrpServiceServletPort();
        BindingProvider bindingProvider = (BindingProvider) port;

        TrustManager[] trustManagers =
                {
                        _trustManagerFactory
                                .createUsingConfiguredTrustStores(true, getDomainName(resolveEndpoint()))
                };

        SSLContext sc;
        try
        {
            sc = SSLContext.getInstance("SSL");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw _exceptionFactory.configurationException("Could not create SSLContext.");
        }
        try
        {
            sc.init(null, trustManagers, new java.security.SecureRandom());
        }
        catch (KeyManagementException e)
        {
            throw _exceptionFactory.configurationException(String.format("Could not initialize SSLcontext %s",
                    e.getMessage()));
        }

        String endpoint = resolveEndpoint();
        bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

        final String JAXWS_PROPERTIES_SSL_SOCKET_FACTORY_INTERNAL
                = "com.sun.xml.internal.ws.transport.https.client.SSLSocketFactory";
        bindingProvider.getRequestContext().put(JAXWS_PROPERTIES_SSL_SOCKET_FACTORY_INTERNAL, sc.getSocketFactory());

        return port;

    }

    private String resolveEndpoint()
    {

        if (_operationalMode.equals(GRPOperationalMode.TEST))
        {
            return _authenticationMode.equals(GRPAuthenticationMode.GRP) ? GRP_TEST_ENDPOINT : EID_TEST_ENDPOINT;
        }
        else
        {
            return _authenticationMode.equals(GRPAuthenticationMode.GRP) ? GRP_PROD_ENDPOINT : EID_PROD_ENDPOINT;
        }

    }

    String getDomainName(String url)
    {
        URI uri;
        try
        {
            uri = new URI(url);
        }
        catch (URISyntaxException e)
        {
            throw _exceptionFactory.configurationException(DOMAIN_NAME_COULD_NOT_BE_PARSED);
        }

        String domain = uri.getHost();

        if (domain != null)
        {
            return domain.startsWith("www.") ? domain.substring(4) : domain;
        }
        else
        {
            throw _exceptionFactory.configurationException(DOMAIN_NAME_COULD_NOT_BE_PARSED);
        }
    }

    private String extractErrorMessage(GrpFault grpFault)
    {
        String errorMessage = "Error response from GRPv2.";
        @Nullable GrpFaultType grpFaultInfo = grpFault.getFaultInfo(); // Treat as nullable to be on the safe side

        if (grpFaultInfo != null)
        {
            String faultStatus = grpFaultInfo.getFaultStatus();
            String detailedDescription = grpFaultInfo.getDetailedDescription();
            StringJoiner msgJoiner = new StringJoiner(" ");
            errorMessage = msgJoiner.add(errorMessage)
                    .add("Error status code:")
                    .add(faultStatus)
                    .add("Message:")
                    .add(detailedDescription).toString();
        }
        return errorMessage;
    }
}

