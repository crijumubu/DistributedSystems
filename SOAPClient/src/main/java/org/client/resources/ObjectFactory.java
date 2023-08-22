
package resources;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the resources package. 
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

    private final static QName _GetSongByTitleResponse_QNAME = new QName("http://classes.server.org/", "GetSongByTitleResponse");
    private final static QName _GetSongs_QNAME = new QName("http://classes.server.org/", "GetSongs");
    private final static QName _GetSongsResponse_QNAME = new QName("http://classes.server.org/", "GetSongsResponse");
    private final static QName _GetSongByTitle_QNAME = new QName("http://classes.server.org/", "GetSongByTitle");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: resources
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSongByTitleResponse }
     * 
     */
    public GetSongByTitleResponse createGetSongByTitleResponse() {
        return new GetSongByTitleResponse();
    }

    /**
     * Create an instance of {@link GetSongs }
     * 
     */
    public GetSongs createGetSongs() {
        return new GetSongs();
    }

    /**
     * Create an instance of {@link GetSongsResponse }
     * 
     */
    public GetSongsResponse createGetSongsResponse() {
        return new GetSongsResponse();
    }

    /**
     * Create an instance of {@link GetSongByTitle }
     * 
     */
    public GetSongByTitle createGetSongByTitle() {
        return new GetSongByTitle();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSongByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://classes.server.org/", name = "GetSongByTitleResponse")
    public JAXBElement<GetSongByTitleResponse> createGetSongByTitleResponse(GetSongByTitleResponse value) {
        return new JAXBElement<GetSongByTitleResponse>(_GetSongByTitleResponse_QNAME, GetSongByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSongs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://classes.server.org/", name = "GetSongs")
    public JAXBElement<GetSongs> createGetSongs(GetSongs value) {
        return new JAXBElement<GetSongs>(_GetSongs_QNAME, GetSongs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSongsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://classes.server.org/", name = "GetSongsResponse")
    public JAXBElement<GetSongsResponse> createGetSongsResponse(GetSongsResponse value) {
        return new JAXBElement<GetSongsResponse>(_GetSongsResponse_QNAME, GetSongsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSongByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://classes.server.org/", name = "GetSongByTitle")
    public JAXBElement<GetSongByTitle> createGetSongByTitle(GetSongByTitle value) {
        return new JAXBElement<GetSongByTitle>(_GetSongByTitle_QNAME, GetSongByTitle.class, null, value);
    }

}
