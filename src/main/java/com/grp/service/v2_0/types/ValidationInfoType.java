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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValidationInfoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ValidationInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signatureFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ocspResponse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidationInfoType", propOrder = {
        "signature",
        "signatureFormat",
        "ocspResponse"
})
public class ValidationInfoType
{

    protected String signature;
    protected String signatureFormat;
    protected String ocspResponse;

    /**
     * Gets the value of the signature property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSignature()
    {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSignature(String value)
    {
        this.signature = value;
    }

    /**
     * Gets the value of the signatureFormat property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSignatureFormat()
    {
        return signatureFormat;
    }

    /**
     * Sets the value of the signatureFormat property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSignatureFormat(String value)
    {
        this.signatureFormat = value;
    }

    /**
     * Gets the value of the ocspResponse property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getOcspResponse()
    {
        return ocspResponse;
    }

    /**
     * Sets the value of the ocspResponse property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setOcspResponse(String value)
    {
        this.ocspResponse = value;
    }

}
