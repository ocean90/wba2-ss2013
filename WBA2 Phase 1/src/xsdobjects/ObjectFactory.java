//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.09 at 09:42:29 PM MESZ 
//


package xsdobjects;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xsdobjects package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Severity_QNAME = new QName("", "severity");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xsdobjects
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Ingredients }
     * 
     */
    public Ingredients createIngredients() {
        return new Ingredients();
    }

    /**
     * Create an instance of {@link Images }
     * 
     */
    public Images createImages() {
        return new Images();
    }

    /**
     * Create an instance of {@link CommentAuthor }
     * 
     */
    public CommentAuthor createCommentAuthor() {
        return new CommentAuthor();
    }

    /**
     * Create an instance of {@link Comment.Replies }
     * 
     */
    public Comment.Replies createCommentReplies() {
        return new Comment.Replies();
    }

    /**
     * Create an instance of {@link Comments }
     * 
     */
    public Comments createComments() {
        return new Comments();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link Comment }
     * 
     */
    public Comment createComment() {
        return new Comment();
    }

    /**
     * Create an instance of {@link Recipe }
     * 
     */
    public Recipe createRecipe() {
        return new Recipe();
    }

    /**
     * Create an instance of {@link Recipes }
     * 
     */
    public Recipes createRecipes() {
        return new Recipes();
    }

    /**
     * Create an instance of {@link Direction }
     * 
     */
    public Direction createDirection() {
        return new Direction();
    }

    /**
     * Create an instance of {@link Avatar }
     * 
     */
    public Avatar createAvatar() {
        return new Avatar();
    }

    /**
     * Create an instance of {@link Steps }
     * 
     */
    public Steps createSteps() {
        return new Steps();
    }

    /**
     * Create an instance of {@link Image }
     * 
     */
    public Image createImage() {
        return new Image();
    }

    /**
     * Create an instance of {@link Ingredient }
     * 
     */
    public Ingredient createIngredient() {
        return new Ingredient();
    }

    /**
     * Create an instance of {@link Times }
     * 
     */
    public Times createTimes() {
        return new Times();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "severity")
    public JAXBElement<String> createSeverity(String value) {
        return new JAXBElement<String>(_Severity_QNAME, String.class, null, value);
    }

}