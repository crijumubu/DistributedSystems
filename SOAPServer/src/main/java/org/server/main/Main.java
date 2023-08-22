package org.server.main;

import org.server.classes.Player;

import javax.xml.ws.Endpoint;

public class Main{

    public static void main(String[] args) {

        Player player = new Player();
        Endpoint.publish("http://localhost:1802/WS/Player", player);

        System.out.println("Server is running at: http://localhost:1802/WS/Player");
    }

}
