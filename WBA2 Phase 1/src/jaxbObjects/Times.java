//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.12 at 04:11:18 PM MESZ 
//


package jaxbObjects;

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
 *         &lt;element ref="{}pre" minOccurs="0"/>
 *         &lt;element ref="{}cook" minOccurs="0"/>
 *         &lt;element ref="{}rest" minOccurs="0"/>
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
    "pre",
    "cook",
    "rest"
})
@XmlRootElement(name = "times")
public class Times {

    protected Pre pre;
    protected Cook cook;
    protected Rest rest;

    /**
     * Gets the value of the pre property.
     * 
     * @return
     *     possible object is
     *     {@link Pre }
     *     
     */
    public Pre getPre() {
        return pre;
    }

    /**
     * Sets the value of the pre property.
     * 
     * @param value
     *     allowed object is
     *     {@link Pre }
     *     
     */
    public void setPre(Pre value) {
        this.pre = value;
    }

    /**
     * Gets the value of the cook property.
     * 
     * @return
     *     possible object is
     *     {@link Cook }
     *     
     */
    public Cook getCook() {
        return cook;
    }

    /**
     * Sets the value of the cook property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cook }
     *     
     */
    public void setCook(Cook value) {
        this.cook = value;
    }

    /**
     * Gets the value of the rest property.
     * 
     * @return
     *     possible object is
     *     {@link Rest }
     *     
     */
    public Rest getRest() {
        return rest;
    }

    /**
     * Sets the value of the rest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rest }
     *     
     */
    public void setRest(Rest value) {
        this.rest = value;
    }

}
