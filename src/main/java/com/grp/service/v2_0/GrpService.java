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

package com.grp.service.v2_0;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "GrpService", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", wsdlLocation = "GRPv2Service.wsdl")
public class GrpService
        extends Service
{

    private final static URL GRPSERVICE_WSDL_LOCATION;
    private final static WebServiceException GRPSERVICE_EXCEPTION;
    private final static QName GRPSERVICE_QNAME = new QName("http://mobilityguard.com/grp/service/v2.0/", "GrpService");

    static
    {
        URL url = null;
        WebServiceException e = null;
        try
        {
            url = GrpService.class.getClassLoader().getResource("soap/GRPv2Service.wsdl");
        }
        catch (Exception ex)
        {
            e = new WebServiceException(ex);
        }
        GRPSERVICE_WSDL_LOCATION = url;
        GRPSERVICE_EXCEPTION = e;
    }

    public GrpService()
    {
        super(__getWsdlLocation(), GRPSERVICE_QNAME);
    }

    public GrpService(WebServiceFeature... features)
    {
        super(__getWsdlLocation(), GRPSERVICE_QNAME, features);
    }

    public GrpService(URL wsdlLocation)
    {
        super(wsdlLocation, GRPSERVICE_QNAME);
    }

    public GrpService(URL wsdlLocation, WebServiceFeature... features)
    {
        super(wsdlLocation, GRPSERVICE_QNAME, features);
    }

    public GrpService(URL wsdlLocation, QName serviceName)
    {
        super(wsdlLocation, serviceName);
    }

    public GrpService(URL wsdlLocation, QName serviceName, WebServiceFeature... features)
    {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * @return returns GrpServicePortType
     */
    @WebEndpoint(name = "GrpServiceServletPort")
    public GrpServicePortType getGrpServiceServletPort()
    {
        return super.getPort(new QName("http://mobilityguard.com/grp/service/v2.0/", "GrpServiceServletPort"), GrpServicePortType.class);
    }

    /**
     * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return returns GrpServicePortType
     */
    @WebEndpoint(name = "GrpServiceServletPort")
    public GrpServicePortType getGrpServiceServletPort(WebServiceFeature... features)
    {
        return super.getPort(new QName("http://mobilityguard.com/grp/service/v2.0/", "GrpServiceServletPort"), GrpServicePortType.class, features);
    }

    private static URL __getWsdlLocation()
    {
        if (GRPSERVICE_EXCEPTION != null)
        {
            throw GRPSERVICE_EXCEPTION;
        }
        return GRPSERVICE_WSDL_LOCATION;
    }

}
