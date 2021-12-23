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

package com.grp.service.v2_0.types;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the io.curity.identityserver.plugin.soap package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory
{

    private final static QName _StatusResponse_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "StatusResponse");
    private final static QName _CollectResponse_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "CollectResponse");
    private final static QName _CollectRequest_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "CollectRequest");
    private final static QName _StatusRequest_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "StatusRequest");
    private final static QName _AuthenticateResponse_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "AuthenticateResponse");
    private final static QName _DisplayNameRequest_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "DisplayNameRequest");
    private final static QName _SignRequest_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "SignRequest");
    private final static QName _CancelResponse_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "CancelResponse");
    private final static QName _CancelRequest_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "CancelRequest");
    private final static QName _GrpFault_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "GrpFault");
    private final static QName _AuthenticateRequest_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "AuthenticateRequest");
    private final static QName _DisplayNameResponse_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "DisplayNameResponse");
    private final static QName _SignResponse_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "SignResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: io.curity.identityserver.plugin.soap
     */
    public ObjectFactory()
    {
    }

    /**
     * Create an instance of {@link DisplayNameRequestType }
     */
    public DisplayNameRequestType createDisplayNameRequestType()
    {
        return new DisplayNameRequestType();
    }

    /**
     * Create an instance of {@link OrderResponseType }
     */
    public OrderResponseType createOrderResponseType()
    {
        return new OrderResponseType();
    }

    /**
     * Create an instance of {@link StatusRequestType }
     */
    public StatusRequestType createStatusRequestType()
    {
        return new StatusRequestType();
    }

    /**
     * Create an instance of {@link SignRequestType }
     */
    public SignRequestType createSignRequestType()
    {
        return new SignRequestType();
    }

    /**
     * Create an instance of {@link StatusResponseType }
     */
    public StatusResponseType createStatusResponseType()
    {
        return new StatusResponseType();
    }

    /**
     * Create an instance of {@link CollectRequestType }
     */
    public CollectRequestType createCollectRequestType()
    {
        return new CollectRequestType();
    }

    /**
     * Create an instance of {@link CollectResponseType }
     */
    public CollectResponseType createCollectResponseType()
    {
        return new CollectResponseType();
    }

    /**
     * Create an instance of {@link DisplayNameResponseType }
     */
    public DisplayNameResponseType createDisplayNameResponseType()
    {
        return new DisplayNameResponseType();
    }

    /**
     * Create an instance of {@link AuthenticateRequestType }
     */
    public AuthenticateRequestType createAuthenticateRequestType()
    {
        return new AuthenticateRequestType();
    }

    /**
     * Create an instance of {@link CancelRequestType }
     */
    public CancelRequestType createCancelRequestType()
    {
        return new CancelRequestType();
    }

    /**
     * Create an instance of {@link CancelResponseType }
     */
    public CancelResponseType createCancelResponseType()
    {
        return new CancelResponseType();
    }

    /**
     * Create an instance of {@link GrpFaultType }
     */
    public GrpFaultType createGrpFaultType()
    {
        return new GrpFaultType();
    }

    /**
     * Create an instance of {@link ValidationInfoType }
     */
    public ValidationInfoType createValidationInfoType()
    {
        return new ValidationInfoType();
    }

    /**
     * Create an instance of {@link EndUserInfoType }
     */
    public EndUserInfoType createEndUserInfoType()
    {
        return new EndUserInfoType();
    }

    /**
     * Create an instance of {@link UserInfoType }
     */
    public UserInfoType createUserInfoType()
    {
        return new UserInfoType();
    }

    /**
     * Create an instance of {@link RequirementAlternativesType }
     */
    public RequirementAlternativesType createRequirementAlternativesType()
    {
        return new RequirementAlternativesType();
    }

    /**
     * Create an instance of {@link RequirementType }
     */
    public RequirementType createRequirementType()
    {
        return new RequirementType();
    }

    /**
     * Create an instance of {@link ConditionType }
     */
    public ConditionType createConditionType()
    {
        return new ConditionType();
    }

    /**
     * Create an instance of {@link Property }
     */
    public Property createProperty()
    {
        return new Property();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusResponseType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "StatusResponse")
    public JAXBElement<StatusResponseType> createStatusResponse(StatusResponseType value)
    {
        return new JAXBElement<StatusResponseType>(_StatusResponse_QNAME, StatusResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CollectResponseType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "CollectResponse")
    public JAXBElement<CollectResponseType> createCollectResponse(CollectResponseType value)
    {
        return new JAXBElement<CollectResponseType>(_CollectResponse_QNAME, CollectResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CollectRequestType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "CollectRequest")
    public JAXBElement<CollectRequestType> createCollectRequest(CollectRequestType value)
    {
        return new JAXBElement<CollectRequestType>(_CollectRequest_QNAME, CollectRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusRequestType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "StatusRequest")
    public JAXBElement<StatusRequestType> createStatusRequest(StatusRequestType value)
    {
        return new JAXBElement<StatusRequestType>(_StatusRequest_QNAME, StatusRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderResponseType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "AuthenticateResponse")
    public JAXBElement<OrderResponseType> createAuthenticateResponse(OrderResponseType value)
    {
        return new JAXBElement<OrderResponseType>(_AuthenticateResponse_QNAME, OrderResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayNameRequestType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "DisplayNameRequest")
    public JAXBElement<DisplayNameRequestType> createDisplayNameRequest(DisplayNameRequestType value)
    {
        return new JAXBElement<DisplayNameRequestType>(_DisplayNameRequest_QNAME, DisplayNameRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SignRequestType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "SignRequest")
    public JAXBElement<SignRequestType> createSignRequest(SignRequestType value)
    {
        return new JAXBElement<SignRequestType>(_SignRequest_QNAME, SignRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelResponseType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "CancelResponse")
    public JAXBElement<CancelResponseType> createCancelResponse(CancelResponseType value)
    {
        return new JAXBElement<CancelResponseType>(_CancelResponse_QNAME, CancelResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelRequestType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "CancelRequest")
    public JAXBElement<CancelRequestType> createCancelRequest(CancelRequestType value)
    {
        return new JAXBElement<CancelRequestType>(_CancelRequest_QNAME, CancelRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GrpFaultType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "GrpFault")
    public JAXBElement<GrpFaultType> createGrpFault(GrpFaultType value)
    {
        return new JAXBElement<GrpFaultType>(_GrpFault_QNAME, GrpFaultType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AuthenticateRequestType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "AuthenticateRequest")
    public JAXBElement<AuthenticateRequestType> createAuthenticateRequest(AuthenticateRequestType value)
    {
        return new JAXBElement<AuthenticateRequestType>(_AuthenticateRequest_QNAME, AuthenticateRequestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayNameResponseType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "DisplayNameResponse")
    public JAXBElement<DisplayNameResponseType> createDisplayNameResponse(DisplayNameResponseType value)
    {
        return new JAXBElement<DisplayNameResponseType>(_DisplayNameResponse_QNAME, DisplayNameResponseType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrderResponseType }{@code >}}
     */
    @XmlElementDecl(namespace = "http://mobilityguard.com/grp/service/v2.0/", name = "SignResponse")
    public JAXBElement<OrderResponseType> createSignResponse(OrderResponseType value)
    {
        return new JAXBElement<OrderResponseType>(_SignResponse_QNAME, OrderResponseType.class, null, value);
    }

}
