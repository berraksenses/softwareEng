
package com.mycompany.soapforexam;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.soapforexam package. 
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

    private final static QName _GetMovieDataResponse_QNAME = new QName("http://soapforexam.mycompany.com/", "getMovieDataResponse");
    private final static QName _GetMoviesResponse_QNAME = new QName("http://soapforexam.mycompany.com/", "getMoviesResponse");
    private final static QName _GetMovies_QNAME = new QName("http://soapforexam.mycompany.com/", "getMovies");
    private final static QName _GetMovieData_QNAME = new QName("http://soapforexam.mycompany.com/", "getMovieData");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.soapforexam
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMovies }
     * 
     */
    public GetMovies createGetMovies() {
        return new GetMovies();
    }

    /**
     * Create an instance of {@link GetMovieDataResponse }
     * 
     */
    public GetMovieDataResponse createGetMovieDataResponse() {
        return new GetMovieDataResponse();
    }

    /**
     * Create an instance of {@link GetMoviesResponse }
     * 
     */
    public GetMoviesResponse createGetMoviesResponse() {
        return new GetMoviesResponse();
    }

    /**
     * Create an instance of {@link GetMovieData }
     * 
     */
    public GetMovieData createGetMovieData() {
        return new GetMovieData();
    }

    /**
     * Create an instance of {@link Movies }
     * 
     */
    public Movies createMovies() {
        return new Movies();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapforexam.mycompany.com/", name = "getMovieDataResponse")
    public JAXBElement<GetMovieDataResponse> createGetMovieDataResponse(GetMovieDataResponse value) {
        return new JAXBElement<GetMovieDataResponse>(_GetMovieDataResponse_QNAME, GetMovieDataResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapforexam.mycompany.com/", name = "getMoviesResponse")
    public JAXBElement<GetMoviesResponse> createGetMoviesResponse(GetMoviesResponse value) {
        return new JAXBElement<GetMoviesResponse>(_GetMoviesResponse_QNAME, GetMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapforexam.mycompany.com/", name = "getMovies")
    public JAXBElement<GetMovies> createGetMovies(GetMovies value) {
        return new JAXBElement<GetMovies>(_GetMovies_QNAME, GetMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://soapforexam.mycompany.com/", name = "getMovieData")
    public JAXBElement<GetMovieData> createGetMovieData(GetMovieData value) {
        return new JAXBElement<GetMovieData>(_GetMovieData_QNAME, GetMovieData.class, null, value);
    }

}
