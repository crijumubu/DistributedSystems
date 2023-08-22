package main;

import classes.JSocketClient;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("DISTRIBUTED MUSIC INC.\n");

        int choice;

        do {

            System.out.println("Choose one of the following options: ");
            System.out.println("\t 1) Get all available songs");
            System.out.println("\t 2) Exit");
            System.out.print("Enter your choice: ");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();

            JSocketClient jSocketClient = new JSocketClient("127.0.0.1", 1802);

            if (choice == 1){

                jSocketClient.request(choice);
            }
            else {

                break;
            }
        } while (choice != 2);
    }
}