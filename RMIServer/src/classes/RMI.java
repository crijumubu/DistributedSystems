package classes;

import interfaces.iRMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RMI extends UnicastRemoteObject implements iRMI {

    private ArrayList<Song> songs;

    public RMI() throws RemoteException{

        songs = new ArrayList<Song>();

        this.songs.add(new classes.Song("Hawái", new String[]{"Maluma"}, "Reggaetón", "29 de julio de 2020"));
        this.songs.add(new classes.Song("Tusa", new String[]{"Karol G", "Nicki Minaj"}, "Reggaetón", "7 de noviembre de 2019"));
        this.songs.add(new classes.Song("Colocao", new String[]{"Nicky Jam"}, "Reggaetón", "14 de mayo de 2020"));
        this.songs.add(new classes.Song("Una Vez Más", new String[]{"Lenny Tavárez", "Dalex", "Beéle"}, "Reggaetón/R&B", "5 de marzo de 2021"));
        this.songs.add(new classes.Song("Rojo", new String[]{"J Balvin"}, "Reggaetón", "19 de marzo de 2020"));
        this.songs.add(new classes.Song("Dákiti", new String[]{"Bad Bunny", "Jhay Cortez"}, "Reggaetón", "30 de octubre de 2020"));
        this.songs.add(new classes.Song("Baila Baila Baila", new String[]{"Ozuna"}, "Reggaetón", "5 de diciembre de 2018"));
        this.songs.add(new classes.Song("Tutu", new String[]{"Camilo", "Pedro Capó"}, "Pop", "5 de abril de 2019"));
        this.songs.add(new classes.Song("La Canción", new String[]{"J Balvin", "Bad Bunny"}, "Reggaetón", "28 de junio de 2019"));
        this.songs.add(new classes.Song("Vete", new String[]{"Bad Bunny"}, "Trap", "22 de noviembre de 2019"));
    }

    @Override
    public ArrayList<Song> GetSongByTitle(String title){

        ArrayList<Song> matches = new ArrayList<Song>();

        for (Song song : this.songs){

            Pattern pattern = Pattern.compile(title, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(song.GetTitle());
            boolean matchFound = matcher.find();

            if(matchFound) {

                matches.add(song);
            }
        }

        return matches;
    }
    @Override
    public ArrayList<Song> GetSongs(){

        return songs;
    }
}
