
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
 *         &lt;element name="getDatosPorCURPResult" type="{http://tempuri.org/}ArrayOfRespuesta" minOccurs="0"/>
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
    "getDatosPorCURPResult"
})
@XmlRootElement(name = "getDatosPorCURPResponse")
public class GetDatosPorCURPResponse {

    protected ArrayOfRespuesta getDatosPorCURPResult;

    /**
     * Gets the value of the getDatosPorCURPResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfRespuesta }
     *     
     */
    public ArrayOfRespuesta getGetDatosPorCURPResult() {
        return getDatosPorCURPResult;
    }

    /**
     * Sets the value of the getDatosPorCURPResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfRespuesta }
     *     
     */
    public void setGetDatosPorCURPResult(ArrayOfRespuesta value) {
        this.getDatosPorCURPResult = value;
    }

}
