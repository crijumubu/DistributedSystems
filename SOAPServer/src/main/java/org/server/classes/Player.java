package org.server.classes;

import org.server.interfaces.IPlayer;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebService
public class Player implements IPlayer{

    private ArrayList<Song> songs;

    public Player(){

        songs = new ArrayList<Song>();

        this.songs.add(new Song("Hawái", new String[]{"Maluma"}, "Reggaetón", "29 de julio de 2020"));
        this.songs.add(new Song("Tusa", new String[]{"Karol G", "Nicki Minaj"}, "Reggaetón", "7 de noviembre de 2019"));
        this.songs.add(new Song("Colocao", new String[]{"Nicky Jam"}, "Reggaetón", "14 de mayo de 2020"));
        this.songs.add(new Song("Una Vez Más", new String[]{"Lenny Tavárez", "Dalex", "Beéle"}, "Reggaetón/R&B", "5 de marzo de 2021"));
        this.songs.add(new Song("Rojo", new String[]{"J Balvin"}, "Reggaetón", "19 de marzo de 2020"));
        this.songs.add(new Song("Dákiti", new String[]{"Bad Bunny", "Jhay Cortez"}, "Reggaetón", "30 de octubre de 2020"));
        this.songs.add(new Song("Baila Baila Baila", new String[]{"Ozuna"}, "Reggaetón", "5 de diciembre de 2018"));
        this.songs.add(new Song("Tutu", new String[]{"Camilo", "Pedro Capó"}, "Pop", "5 de abril de 2019"));
        this.songs.add(new Song("La Canción", new String[]{"J Balvin", "Bad Bunny"}, "Reggaetón", "28 de junio de 2019"));
        this.songs.add(new Song("Vete", new String[]{"Bad Bunny"}, "Trap", "22 de noviembre de 2019"));
    }

    @WebMethod
    public ArrayList<String> GetSongByTitle(String title){

        ArrayList<String> matches = new ArrayList<String>();

        for (Song song : this.songs){

            Pattern pattern = Pattern.compile(title, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(song.GetTitle());
            boolean matchFound = matcher.find();

            if(matchFound) {

                matches.add(song.toString());
            }
        }

        return matches;
    }

    @WebMethod
    public ArrayList<String> GetSongs(){

        ArrayList<String> songs = new ArrayList<String>();

        for (Song song : this.songs){

            songs.add(song.toString());
        }
        return songs;
    }
}

