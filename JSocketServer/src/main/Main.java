package main;

import classes.JSocketServer;

public class Main {

    public static void main(String[] args) {

        JSocketServer jSocketServer = new JSocketServer(1802);
        jSocketServer.response();
    }
}