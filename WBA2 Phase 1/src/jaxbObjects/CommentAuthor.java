//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.12 at 01:16:30 AM MESZ 
//


package jaxbObjects;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}avatar" minOccurs="0"/>
 *         &lt;element name="userLevel" type="{http://www.w3.org/2001/XMLSchema}integer"/>
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
    "name",
    "avatar",
    "userLevel"
})
@XmlRootElement(name = "commentAuthor")
public class CommentAuthor {

    @XmlElement(required = true)
    protected String name;
    protected Avatar avatar;
    @XmlElement(required = true)
    protected BigInteger userLevel;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the avatar property.
     * 
     * @return
     *     possible object is
     *     {@link Avatar }
     *     
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * Sets the value of the avatar property.
     * 
     * @param value
     *     allowed object is
     *     {@link Avatar }
     *     
     */
    public void setAvatar(Avatar value) {
        this.avatar = value;
    }

    /**
     * Gets the value of the userLevel property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUserLevel() {
        return userLevel;
    }

    /**
     * Sets the value of the userLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUserLevel(BigInteger value) {
        this.userLevel = value;
    }

}
