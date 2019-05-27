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
 * <p>Java class for CollectResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CollectResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transactionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="progressStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="userInfo" type="{http://mobilityguard.com/grp/service/v2.0/}UserInfoType" minOccurs="0"/>
 *         &lt;element name="validationInfo" type="{http://mobilityguard.com/grp/service/v2.0/}ValidationInfoType" minOccurs="0"/>
 *         &lt;element name="attributes" type="{http://mobilityguard.com/grp/service/v2.0/}Property" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CollectResponseType", propOrder = {
        "transactionId",
        "progressStatus",
        "userInfo",
        "validationInfo",
        "attributes"
})
public class CollectResponseType
{

    protected String transactionId;
    @XmlElement(required = true)
    protected String progressStatus;
    protected UserInfoType userInfo;
    protected ValidationInfoType validationInfo;
    @XmlElement(nillable = true)
    protected List<Property> attributes;

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
     * Gets the value of the progressStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProgressStatus()
    {
        return progressStatus;
    }

    /**
     * Sets the value of the progressStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProgressStatus(String value)
    {
        this.progressStatus = value;
    }

    /**
     * Gets the value of the userInfo property.
     *
     * @return possible object is
     * {@link UserInfoType }
     */
    public UserInfoType getUserInfo()
    {
        return userInfo;
    }

    /**
     * Sets the value of the userInfo property.
     *
     * @param value allowed object is
     *              {@link UserInfoType }
     */
    public void setUserInfo(UserInfoType value)
    {
        this.userInfo = value;
    }

    /**
     * Gets the value of the validationInfo property.
     *
     * @return possible object is
     * {@link ValidationInfoType }
     */
    public ValidationInfoType getValidationInfo()
    {
        return validationInfo;
    }

    /**
     * Sets the value of the validationInfo property.
     *
     * @param value allowed object is
     *              {@link ValidationInfoType }
     */
    public void setValidationInfo(ValidationInfoType value)
    {
        this.validationInfo = value;
    }

    /**
     * Gets the value of the attributes property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the attributes property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAttributes().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Property }
     */
    public List<Property> getAttributes()
    {
        if (attributes == null)
        {
            attributes = new ArrayList<Property>();
        }
        return this.attributes;
    }

}
