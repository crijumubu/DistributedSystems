
package resources;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Player", targetNamespace = "http://classes.server.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Player {


    /**
     * 
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(operationName = "GetSongs")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetSongs", targetNamespace = "http://classes.server.org/", className = "resources.GetSongs")
    @ResponseWrapper(localName = "GetSongsResponse", targetNamespace = "http://classes.server.org/", className = "resources.GetSongsResponse")
    @Action(input = "http://classes.server.org/Player/GetSongsRequest", output = "http://classes.server.org/Player/GetSongsResponse")
    public List<String> getSongs();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod(operationName = "GetSongByTitle")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "GetSongByTitle", targetNamespace = "http://classes.server.org/", className = "resources.GetSongByTitle")
    @ResponseWrapper(localName = "GetSongByTitleResponse", targetNamespace = "http://classes.server.org/", className = "resources.GetSongByTitleResponse")
    @Action(input = "http://classes.server.org/Player/GetSongByTitleRequest", output = "http://classes.server.org/Player/GetSongByTitleResponse")
    public List<String> getSongByTitle(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}