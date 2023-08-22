package classes;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class JSocketClient {

    private Socket socket;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private String address;
    private int port;

    public JSocketClient(String address, int port) {

        this.socket = null;
        this.address = address;
        this.port = port;
        this.objectInputStream = null;
        this.objectOutputStream = null;
    }

    public void request(int choice){

        try {

            this.socket = new Socket(this.address, this.port);

            this.objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            this.objectInputStream = new ObjectInputStream(socket.getInputStream());

            objectOutputStream.writeObject(choice);
            List<Song> songs = (List<Song>) objectInputStream.readObject();

            System.out.print("\n");
            for (Song song : songs){

                System.out.println(song.toString() + "\n");
            }

            CloseSocket();

        } catch (IOException e){

            System.out.println("\n[Client]: " + "Unable to establish communication with the server");

        } catch (ClassNotFoundException e){

            System.out.println("\n[Client]: " + "Something went wrong while getting the data from the server");
        }
    }

    public void CloseSocket(){

        try {


            this.socket.close();
            this.objectInputStream.close();
            this.objectOutputStream.close();

        } catch (IOException e) {

            System.out.println("\n[Client]: " + "Unable to close connection to the server");
        }
    }
}