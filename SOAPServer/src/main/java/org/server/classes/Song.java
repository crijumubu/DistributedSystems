package org.server.classes;

import java.io.Serializable;
import java.util.Arrays;

public class Song implements Serializable {

    private String title;
    private String[] artists;
    private String genre;
    private String releaseDate;

    public Song(String title, String[] artists, String genre, String releaseDate) {

        this.title = title;
        this.artists = artists;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String GetTitle() {

        return title;
    }

    public String toString(){

        return "Title: " + title + "\nArtists: " + Arrays.toString(artists) + "\nGenre: " + genre + "\nRelease date: " + releaseDate;
    }
}
