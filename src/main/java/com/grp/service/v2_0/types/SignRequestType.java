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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SignRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SignRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="policy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="provider" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="rpDisplayName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subjectIdentifier" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userVisibleData" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userNonVisibleData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endUserInfo" type="{http://mobilityguard.com/grp/service/v2.0/}EndUserInfoType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="requirementAlternatives" type="{http://mobilityguard.com/grp/service/v2.0/}RequirementAlternativesType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignRequestType", propOrder = {
        "policy",
        "provider",
        "rpDisplayName",
        "transactionId",
        "subjectIdentifier",
        "userVisibleData",
        "userNonVisibleData",
        "endUserInfo",
        "requirementAlternatives"
})
public class SignRequestType
{

    @XmlElement(required = true)
    protected String policy;
    @XmlElement(required = true)
    protected String provider;
    @XmlElement(required = true)
    protected String rpDisplayName;
    protected String transactionId;
    protected String subjectIdentifier;
    @XmlElement(required = true)
    protected String userVisibleData;
    protected String userNonVisibleData;
    @XmlElement(nillable = true)
    protected List<EndUserInfoType> endUserInfo;
    protected RequirementAlternativesType requirementAlternatives;

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
     * Gets the value of the rpDisplayName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRpDisplayName()
    {
        return rpDisplayName;
    }

    /**
     * Sets the value of the rpDisplayName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRpDisplayName(String value)
    {
        this.rpDisplayName = value;
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
     * Gets the value of the userVisibleData property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserVisibleData()
    {
        return userVisibleData;
    }

    /**
     * Sets the value of the userVisibleData property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserVisibleData(String value)
    {
        this.userVisibleData = value;
    }

    /**
     * Gets the value of the userNonVisibleData property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUserNonVisibleData()
    {
        return userNonVisibleData;
    }

    /**
     * Sets the value of the userNonVisibleData property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUserNonVisibleData(String value)
    {
        this.userNonVisibleData = value;
    }

    /**
     * Gets the value of the endUserInfo property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the endUserInfo property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEndUserInfo().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EndUserInfoType }
     */
    public List<EndUserInfoType> getEndUserInfo()
    {
        if (endUserInfo == null)
        {
            endUserInfo = new ArrayList<EndUserInfoType>();
        }
        return this.endUserInfo;
    }

    /**
     * Gets the value of the requirementAlternatives property.
     *
     * @return possible object is
     * {@link RequirementAlternativesType }
     */
    public RequirementAlternativesType getRequirementAlternatives()
    {
        return requirementAlternatives;
    }

    /**
     * Sets the value of the requirementAlternatives property.
     *
     * @param value allowed object is
     *              {@link RequirementAlternativesType }
     */
    public void setRequirementAlternatives(RequirementAlternativesType value)
    {
        this.requirementAlternatives = value;
    }

}
