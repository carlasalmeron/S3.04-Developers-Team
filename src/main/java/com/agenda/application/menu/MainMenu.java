package com.agenda.application.menu;

import com.agenda.event.cli.EventMenu;
import com.agenda.event.dao.EventSqlDAO;
import com.agenda.event.service.EventService;
import com.agenda.note.cli.NoteCli;
import com.agenda.note.repository.NoteRepositoryImplement;
import com.agenda.note.service.NoteService;
import com.agenda.note.service.NoteServiceImplement;

import java.util.Scanner;

public class MainMenu {
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        int option = 0;

        while (option != 4) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Manage Notes");
            System.out.println("2. Manage Events");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("-> Entering the NOTES module...");
                    NoteRepositoryImplement note = new NoteRepositoryImplement();
                    NoteService noteService = new NoteServiceImplement(note);
                    new NoteCli(noteService).showMenu();
                    break;
                case 2:
                    System.out.println("-> Entering the EVENTS module...");
                    EventSqlDAO dao = new EventSqlDAO();
                    EventService service = new EventService(dao);
                    new EventMenu(service).showMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
