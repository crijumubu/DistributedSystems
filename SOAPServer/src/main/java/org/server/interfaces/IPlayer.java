package org.server.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService
public interface IPlayer {

    @WebMethod
    public ArrayList<String> GetSongByTitle(String title);

    @WebMethod
    public ArrayList<String> GetSongs();
}

