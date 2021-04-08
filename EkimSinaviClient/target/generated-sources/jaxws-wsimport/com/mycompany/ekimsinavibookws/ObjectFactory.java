
package com.mycompany.ekimsinavibookws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.ekimsinavibookws package. 
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

    private final static QName _DeliveryTimeResponse_QNAME = new QName("http://ekimsinavibookws.mycompany.com/", "deliveryTimeResponse");
    private final static QName _DeliveryTime_QNAME = new QName("http://ekimsinavibookws.mycompany.com/", "deliveryTime");
    private final static QName _GetInfoAboutBookResponse_QNAME = new QName("http://ekimsinavibookws.mycompany.com/", "getInfoAboutBookResponse");
    private final static QName _GetInfoAboutBook_QNAME = new QName("http://ekimsinavibookws.mycompany.com/", "getInfoAboutBook");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.ekimsinavibookws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeliveryTime }
     * 
     */
    public DeliveryTime createDeliveryTime() {
        return new DeliveryTime();
    }

    /**
     * Create an instance of {@link DeliveryTimeResponse }
     * 
     */
    public DeliveryTimeResponse createDeliveryTimeResponse() {
        return new DeliveryTimeResponse();
    }

    /**
     * Create an instance of {@link GetInfoAboutBook }
     * 
     */
    public GetInfoAboutBook createGetInfoAboutBook() {
        return new GetInfoAboutBook();
    }

    /**
     * Create an instance of {@link GetInfoAboutBookResponse }
     * 
     */
    public GetInfoAboutBookResponse createGetInfoAboutBookResponse() {
        return new GetInfoAboutBookResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ekimsinavibookws.mycompany.com/", name = "deliveryTimeResponse")
    public JAXBElement<DeliveryTimeResponse> createDeliveryTimeResponse(DeliveryTimeResponse value) {
        return new JAXBElement<DeliveryTimeResponse>(_DeliveryTimeResponse_QNAME, DeliveryTimeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeliveryTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ekimsinavibookws.mycompany.com/", name = "deliveryTime")
    public JAXBElement<DeliveryTime> createDeliveryTime(DeliveryTime value) {
        return new JAXBElement<DeliveryTime>(_DeliveryTime_QNAME, DeliveryTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoAboutBookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ekimsinavibookws.mycompany.com/", name = "getInfoAboutBookResponse")
    public JAXBElement<GetInfoAboutBookResponse> createGetInfoAboutBookResponse(GetInfoAboutBookResponse value) {
        return new JAXBElement<GetInfoAboutBookResponse>(_GetInfoAboutBookResponse_QNAME, GetInfoAboutBookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetInfoAboutBook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ekimsinavibookws.mycompany.com/", name = "getInfoAboutBook")
    public JAXBElement<GetInfoAboutBook> createGetInfoAboutBook(GetInfoAboutBook value) {
        return new JAXBElement<GetInfoAboutBook>(_GetInfoAboutBook_QNAME, GetInfoAboutBook.class, null, value);
    }

}
