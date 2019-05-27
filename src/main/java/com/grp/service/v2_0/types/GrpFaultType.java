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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GrpFaultType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GrpFaultType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="faultStatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="detailedDescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GrpFaultType", propOrder = {
        "faultStatus",
        "detailedDescription"
})
public class GrpFaultType
{

    @XmlElement(required = true)
    protected String faultStatus;
    @XmlElement(required = true)
    protected String detailedDescription;

    /**
     * Gets the value of the faultStatus property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFaultStatus()
    {
        return faultStatus;
    }

    /**
     * Sets the value of the faultStatus property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFaultStatus(String value)
    {
        this.faultStatus = value;
    }

    /**
     * Gets the value of the detailedDescription property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDetailedDescription()
    {
        return detailedDescription;
    }

    /**
     * Sets the value of the detailedDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDetailedDescription(String value)
    {
        this.detailedDescription = value;
    }

}
