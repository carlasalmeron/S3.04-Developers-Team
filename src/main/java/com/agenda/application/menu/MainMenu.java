package com.agenda.application.menu;

import java.util.Scanner;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int option = 0;

        while (option != 4) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Manage Tasks");
            System.out.println("2. Manage Notes");
            System.out.println("3. Manage Events");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("-> Entering the TASKS module...");

                    break;
                case 2:
                    System.out.println("-> Entering the NOTES module...");
                    break;
                case 3:
                    System.out.println("-> Entering the EVENTS module...");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
