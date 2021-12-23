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

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for FaultStatusType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FaultStatusType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INVALID_PARAMETERS"/>
 *     &lt;enumeration value="ACCESS_DENIED_RP"/>
 *     &lt;enumeration value="RETRY"/>
 *     &lt;enumeration value="INTERNAL_ERROR"/>
 *     &lt;enumeration value="ALREADY_COLLECTED"/>
 *     &lt;enumeration value="EXPIRED_TRANSACTION"/>
 *     &lt;enumeration value="TIMEOUT"/>
 *     &lt;enumeration value="USER_CANCEL"/>
 *     &lt;enumeration value="CLIENT_ERR"/>
 *     &lt;enumeration value="CERTIFICATE_ERR"/>
 *     &lt;enumeration value="CANCELLED"/>
 *     &lt;enumeration value="START_FAILED"/>
 *     &lt;enumeration value="ALREADY_IN_PROGRESS"/>
 *     &lt;enumeration value="REQ_PRECOND"/>
 *     &lt;enumeration value="REQ_ERROR"/>
 *     &lt;enumeration value="REQ_BLOCKED"/>
 *     &lt;enumeration value="SIGN_VALIDATION_FAILED"/>
 *     &lt;enumeration value="TIME_BLOCKED"/>
 *     &lt;enumeration value="UNKNOWN_USER"/>
 *     &lt;enumeration value="INVALID_DEVICESW"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "FaultStatusType")
@XmlEnum
public enum FaultStatusType
{

    INVALID_PARAMETERS,
    ACCESS_DENIED_RP,
    RETRY,
    INTERNAL_ERROR,
    ALREADY_COLLECTED,
    EXPIRED_TRANSACTION,
    TIMEOUT,
    USER_CANCEL,
    CLIENT_ERR,
    CERTIFICATE_ERR,
    CANCELLED,
    START_FAILED,
    ALREADY_IN_PROGRESS,
    REQ_PRECOND,
    REQ_ERROR,
    REQ_BLOCKED,
    SIGN_VALIDATION_FAILED,
    TIME_BLOCKED,
    UNKNOWN_USER,
    INVALID_DEVICESW;

    public String value()
    {
        return name();
    }

    public static FaultStatusType fromValue(String v)
    {
        return valueOf(v);
    }

}
