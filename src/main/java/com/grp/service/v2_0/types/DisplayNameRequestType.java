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

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for DisplayNameRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="DisplayNameRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DisplayNameRequestType", propOrder = {
        "policy",
        "provider",
        "transactionId"
})
public class DisplayNameRequestType
{

    @XmlElement(required = true)
    protected String policy;
    @XmlElement(required = true)
    protected String provider;
    protected String transactionId;

    /**
     * Gets the value of the policy property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPolicy()
    {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPolicy(String value)
    {
        this.policy = value;
    }

    /**
     * Gets the value of the provider property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProvider()
    {
        return provider;
    }

    /**
     * Sets the value of the provider property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProvider(String value)
    {
        this.provider = value;
    }

    /**
     * Gets the value of the transactionId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTransactionId()
    {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTransactionId(String value)
    {
        this.transactionId = value;
    }

}
