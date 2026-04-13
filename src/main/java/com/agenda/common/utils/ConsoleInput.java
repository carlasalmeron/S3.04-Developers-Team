package com.agenda.common.utils;

import java.util.Scanner;

public class ConsoleInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String message) {
        System.out.print(message + ": ");
        return scanner.nextLine();
    }

    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message + ": ");
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Error: You must enter an integer.");
            }
        }
    }
}
