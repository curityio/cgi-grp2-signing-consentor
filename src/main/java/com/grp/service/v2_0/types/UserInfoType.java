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
 * <p>Java class for UserInfoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UserInfoType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="subjectIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subjectIdentifierType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="displayName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="givenName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ipAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserInfoType", propOrder = {
        "subjectIdentifier",
        "subjectIdentifierType",
        "displayName",
        "givenName",
        "sn",
        "ipAddress"
})
public class UserInfoType
{

    protected String subjectIdentifier;
    @XmlElement(required = true)
    protected String subjectIdentifierType;
    protected String displayName;
    protected String givenName;
    protected String sn;
    protected String ipAddress;

    /**
     * Gets the value of the subjectIdentifier property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubjectIdentifier()
    {
        return subjectIdentifier;
    }

    /**
     * Sets the value of the subjectIdentifier property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubjectIdentifier(String value)
    {
        this.subjectIdentifier = value;
    }

    /**
     * Gets the value of the subjectIdentifierType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubjectIdentifierType()
    {
        return subjectIdentifierType;
    }

    /**
     * Sets the value of the subjectIdentifierType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubjectIdentifierType(String value)
    {
        this.subjectIdentifierType = value;
    }

    /**
     * Gets the value of the displayName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayName()
    {
        return displayName;
    }

    /**
     * Sets the value of the displayName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayName(String value)
    {
        this.displayName = value;
    }

    /**
     * Gets the value of the givenName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGivenName()
    {
        return givenName;
    }

    /**
     * Sets the value of the givenName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGivenName(String value)
    {
        this.givenName = value;
    }

    /**
     * Gets the value of the sn property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSn()
    {
        return sn;
    }

    /**
     * Sets the value of the sn property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSn(String value)
    {
        this.sn = value;
    }

    /**
     * Gets the value of the ipAddress property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIpAddress()
    {
        return ipAddress;
    }

    /**
     * Sets the value of the ipAddress property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIpAddress(String value)
    {
        this.ipAddress = value;
    }

}
