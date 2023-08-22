package main;

import classes.Song;
import interfaces.iRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {

        try{

            iRMI service = (iRMI) Naming.lookup("rmi://127.0.0.1:1802/service");

            System.out.println("DISTRIBUTED MUSIC INC.\n");

            System.out.println("Lista de canciones disponibles:");

            for(Song song : service.GetSongs()){

                System.out.println(song.toString() + "\n");
            }

            System.out.println("Lista de canciones coincidentes con la expresión: \"Dákiti\":\n");

            for(Song song : service.GetSongByTitle("Dákiti")){

                System.out.println(song.toString() + "\n");
            }

        } catch (MalformedURLException | RemoteException | NotBoundException e){

            e.printStackTrace();
        }
    }
}