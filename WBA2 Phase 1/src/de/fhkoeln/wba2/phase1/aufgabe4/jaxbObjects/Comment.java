//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.12 at 04:11:18 PM MESZ 
//


package de.fhkoeln.wba2.phase1.aufgabe4.jaxbObjects;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &lt;element ref="{}commentAuthor"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="isHelpful" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="content" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{}replies" minOccurs="0"/>
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
    "commentAuthor",
    "date",
    "isHelpful",
    "content",
    "replies"
})
@XmlRootElement(name = "comment")
public class Comment {

    @XmlElement(required = true)
    protected CommentAuthor commentAuthor;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    @XmlElement(defaultValue = "false")
    protected boolean isHelpful;
    @XmlElement(required = true)
    protected String content;
    protected Replies replies;

    /**
     * Gets the value of the commentAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link CommentAuthor }
     *     
     */
    public CommentAuthor getCommentAuthor() {
        return commentAuthor;
    }

    /**
     * Sets the value of the commentAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommentAuthor }
     *     
     */
    public void setCommentAuthor(CommentAuthor value) {
        this.commentAuthor = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Gets the value of the isHelpful property.
     * 
     */
    public boolean isIsHelpful() {
        return isHelpful;
    }

    /**
     * Sets the value of the isHelpful property.
     * 
     */
    public void setIsHelpful(boolean value) {
        this.isHelpful = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the replies property.
     * 
     * @return
     *     possible object is
     *     {@link Replies }
     *     
     */
    public Replies getReplies() {
        return replies;
    }

    /**
     * Sets the value of the replies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Replies }
     *     
     */
    public void setReplies(Replies value) {
        this.replies = value;
    }

}
