package org.client.main;

import java.net.URL;
import resources.Player;
import resources.PlayerService;

public class Main {

    public static void main(String[] args) {
        
        try{
            
            PlayerService playerService = new PlayerService(new URL("http://localhost:1802/WS/Player?wsdl"));
            Player player = playerService.getPlayerPort();

            System.out.println("DISTRIBUTED MUSIC INC.\n");

            System.out.println("Lista de canciones disponibles:");

            for (String song : player.getSongs()){

                System.out.println(song + "\n");
            }

            System.out.println("Lista de canciones coincidentes con la expresión: \"Dákiti\":\n");

            for(String song : player.getSongByTitle("Dákiti")){

                System.out.println(song + "\n");
            }

        }catch (Exception e){
            
            System.out.println("Upsss, algo ha salido mal.\n");
        }
    }
}
