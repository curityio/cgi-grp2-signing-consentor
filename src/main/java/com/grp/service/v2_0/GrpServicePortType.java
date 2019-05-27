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

import com.grp.service.v2_0.types.AuthenticateRequestType;
import com.grp.service.v2_0.types.CancelRequestType;
import com.grp.service.v2_0.types.CancelResponseType;
import com.grp.service.v2_0.types.CollectRequestType;
import com.grp.service.v2_0.types.CollectResponseType;
import com.grp.service.v2_0.types.DisplayNameRequestType;
import com.grp.service.v2_0.types.DisplayNameResponseType;
import com.grp.service.v2_0.types.ObjectFactory;
import com.grp.service.v2_0.types.OrderResponseType;
import com.grp.service.v2_0.types.SignRequestType;
import com.grp.service.v2_0.types.StatusRequestType;
import com.grp.service.v2_0.types.StatusResponseType;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

@WebService(name = "GrpServicePortType", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
        ObjectFactory.class
})
public interface GrpServicePortType
{


    /**
     * @param cancelRequest
     * @return returns com.grp.service.v2_0.types.CancelResponseType
     * @throws GrpFault
     */
    @WebMethod(operationName = "Cancel")
    @WebResult(name = "CancelResponse", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "CancelResponse")
    @Action(input = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/CancelRequest", output = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/CancelResponse", fault = {
            @FaultAction(className = GrpFault.class, value = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/Cancel/Fault/GrpFault")
    })
    public CancelResponseType cancel(
            @WebParam(name = "CancelRequest", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "CancelRequest")
                    CancelRequestType cancelRequest)
            throws GrpFault
    ;

    /**
     * @param signRequest
     * @return returns com.grp.service.v2_0.types.OrderResponseType
     * @throws GrpFault
     */
    @WebMethod(operationName = "Sign")
    @WebResult(name = "SignResponse", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "SignResponse")
    @Action(input = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/SignRequest", output = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/SignResponse", fault = {
            @FaultAction(className = GrpFault.class, value = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/Sign/Fault/GrpFault")
    })
    public OrderResponseType sign(
            @WebParam(name = "SignRequest", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "SignRequest")
                    SignRequestType signRequest)
            throws GrpFault
    ;

    /**
     * @param collectRequest
     * @return returns com.grp.service.v2_0.types.CollectResponseType
     * @throws GrpFault
     */
    @WebMethod(operationName = "Collect")
    @WebResult(name = "CollectResponse", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "CollectResponse")
    @Action(input = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/CollectRequest", output = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/CollectResponse", fault = {
            @FaultAction(className = GrpFault.class, value = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/Collect/Fault/GrpFault")
    })
    public CollectResponseType collect(
            @WebParam(name = "CollectRequest", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "CollectRequest")
                    CollectRequestType collectRequest)
            throws GrpFault
    ;

    /**
     * @param statusRequest
     * @return returns com.grp.service.v2_0.types.StatusResponseType
     * @throws GrpFault
     */
    @WebMethod(operationName = "Status")
    @WebResult(name = "StatusResponse", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "StatusResponse")
    @Action(input = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/StatusRequest", output = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/StatusResponse", fault = {
            @FaultAction(className = GrpFault.class, value = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/Status/Fault/GrpFault")
    })
    public StatusResponseType status(
            @WebParam(name = "StatusRequest", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "StatusRequest")
                    StatusRequestType statusRequest)
            throws GrpFault
    ;

    /**
     * @param displayNameRequest
     * @return returns com.grp.service.v2_0.types.DisplayNameResponseType
     * @throws GrpFault
     */
    @WebMethod(operationName = "DisplayName")
    @WebResult(name = "DisplayNameResponse", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "DisplayNameResponse")
    @Action(input = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/DisplayNameRequest", output = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/DisplayNameResponse", fault = {
            @FaultAction(className = GrpFault.class, value = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/DisplayName/Fault/GrpFault")
    })
    public DisplayNameResponseType displayName(
            @WebParam(name = "DisplayNameRequest", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "DisplayNameRequest")
                    DisplayNameRequestType displayNameRequest)
            throws GrpFault
    ;

    /**
     * @param authenticateRequest
     * @return returns com.grp.service.v2_0.types.OrderResponseType
     * @throws GrpFault
     */
    @WebMethod(operationName = "Authenticate")
    @WebResult(name = "AuthenticateResponse", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "AuthenticateResponse")
    @Action(input = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/AuthenticateRequest", output = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/AuthenticateResponse", fault = {
            @FaultAction(className = GrpFault.class, value = "http://mobilityguard.com/grp/service/v2.0/GrpServicePortType/Authenticate/Fault/GrpFault")
    })
    public OrderResponseType authenticate(
            @WebParam(name = "AuthenticateRequest", targetNamespace = "http://mobilityguard.com/grp/service/v2.0/", partName = "AuthenticateRequest")
                    AuthenticateRequestType authenticateRequest)
            throws GrpFault
    ;

}
