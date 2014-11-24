
package com.simavirtual.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.simavirtual.ws package. 
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

    private final static QName _CodigoResponse_QNAME = new QName("http://ws.simavirtual.com/", "codigoResponse");
    private final static QName _Codigo_QNAME = new QName("http://ws.simavirtual.com/", "codigo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.simavirtual.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Codigo }
     * 
     */
    public Codigo createCodigo() {
        return new Codigo();
    }

    /**
     * Create an instance of {@link CodigoResponse }
     * 
     */
    public CodigoResponse createCodigoResponse() {
        return new CodigoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CodigoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.simavirtual.com/", name = "codigoResponse")
    public JAXBElement<CodigoResponse> createCodigoResponse(CodigoResponse value) {
        return new JAXBElement<CodigoResponse>(_CodigoResponse_QNAME, CodigoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Codigo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.simavirtual.com/", name = "codigo")
    public JAXBElement<Codigo> createCodigo(Codigo value) {
        return new JAXBElement<Codigo>(_Codigo_QNAME, Codigo.class, null, value);
    }

}
