package classes;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class JSocketServer{

    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private int port;

    public JSocketServer(int port){

        this.port = port;
        this.objectInputStream = null;
        this.objectOutputStream = null;
    }

    public void response(){

        try {

            this.serverSocket = new ServerSocket(this.port);

            while (true){

                System.out.println("[Server]: " + "Waiting.");

                this.socket = serverSocket.accept();

                this.objectInputStream = new ObjectInputStream(socket.getInputStream());
                this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

                int choice = (int) objectInputStream.readObject();

                if (choice == 1){

                    this.objectOutputStream.writeObject(GetSongs());

                    System.out.println("[Server]: " + "Response to a client done.\n");
                }
            }
        } catch (IOException e){

            System.out.println("\n[Client]: " + "Unable to start the server");

        } catch (ClassNotFoundException e){

            System.out.println("\n[Client]: " + "Something went wrong while getting the data from the client");
        }
    }

    public List<Song> GetSongs(){

        List<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Hawái", new String[]{"Maluma"}, "Reggaetón", "29 de julio de 2020"));
        songs.add(new Song("Tusa", new String[]{"Karol G", "Nicki Minaj"}, "Reggaetón", "7 de noviembre de 2019"));
        songs.add(new Song("Colocao", new String[]{"Nicky Jam"}, "Reggaetón", "14 de mayo de 2020"));
        songs.add(new Song("Una Vez Más", new String[]{"Lenny Tavárez", "Dalex", "Beéle"}, "Reggaetón/R&B", "5 de marzo de 2021"));
        songs.add(new Song("Rojo", new String[]{"J Balvin"}, "Reggaetón", "19 de marzo de 2020"));
        songs.add(new Song("Dákiti", new String[]{"Bad Bunny", "Jhay Cortez"}, "Reggaetón", "30 de octubre de 2020"));
        songs.add(new Song("Baila Baila Baila", new String[]{"Ozuna"}, "Reggaetón", "5 de diciembre de 2018"));
        songs.add(new Song("Tutu", new String[]{"Camilo", "Pedro Capó"}, "Pop", "5 de abril de 2019"));
        songs.add(new Song("La Canción", new String[]{"J Balvin", "Bad Bunny"}, "Reggaetón", "28 de junio de 2019"));
        songs.add(new Song("Vete", new String[]{"Bad Bunny"}, "Trap", "22 de noviembre de 2019"));

        return songs;
    }
}
