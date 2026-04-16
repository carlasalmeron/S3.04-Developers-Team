package com.agenda.application;

import com.agenda.application.menu.MainMenu;

public class AgendaApp {
    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("            PERSONAL AGENDA             ");
        System.out.println("========================================");


        MainMenu menu = new MainMenu();

        menu.start();

        System.out.println("\nProgram finished. Have a nice day!");
    }
}
