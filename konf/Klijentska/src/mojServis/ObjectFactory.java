
package mojServis;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mojServis package. 
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

    private final static QName _GetKonferencije_QNAME = new QName("http://beans/", "getKonferencije");
    private final static QName _GetKonferencijeResponse_QNAME = new QName("http://beans/", "getKonferencijeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mojServis
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetKonferencije }
     * 
     */
    public GetKonferencije createGetKonferencije() {
        return new GetKonferencije();
    }

    /**
     * Create an instance of {@link GetKonferencijeResponse }
     * 
     */
    public GetKonferencijeResponse createGetKonferencijeResponse() {
        return new GetKonferencijeResponse();
    }

    /**
     * Create an instance of {@link Conference }
     * 
     */
    public Conference createConference() {
        return new Conference();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKonferencije }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans/", name = "getKonferencije")
    public JAXBElement<GetKonferencije> createGetKonferencije(GetKonferencije value) {
        return new JAXBElement<GetKonferencije>(_GetKonferencije_QNAME, GetKonferencije.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetKonferencijeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://beans/", name = "getKonferencijeResponse")
    public JAXBElement<GetKonferencijeResponse> createGetKonferencijeResponse(GetKonferencijeResponse value) {
        return new JAXBElement<GetKonferencijeResponse>(_GetKonferencijeResponse_QNAME, GetKonferencijeResponse.class, null, value);
    }

}
