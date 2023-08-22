package interfaces;

import classes.Song;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface iRMI extends Remote{

    public ArrayList<Song> GetSongByTitle(String title) throws RemoteException;
    public ArrayList<Song> GetSongs() throws RemoteException;
}