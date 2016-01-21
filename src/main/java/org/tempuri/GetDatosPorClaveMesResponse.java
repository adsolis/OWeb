
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getDatosPorClaveMesResult" type="{http://tempuri.org/}ArrayOfRespuesta" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getDatosPorClaveMesResult"
})
@XmlRootElement(name = "getDatosPorClaveMesResponse")
public class GetDatosPorClaveMesResponse {

    protected ArrayOfRespuesta getDatosPorClaveMesResult;

    /**
     * Gets the value of the getDatosPorClaveMesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRespuesta }
     *     
     */
    public ArrayOfRespuesta getGetDatosPorClaveMesResult() {
        return getDatosPorClaveMesResult;
    }

    /**
     * Sets the value of the getDatosPorClaveMesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRespuesta }
     *     
     */
    public void setGetDatosPorClaveMesResult(ArrayOfRespuesta value) {
        this.getDatosPorClaveMesResult = value;
    }

}
