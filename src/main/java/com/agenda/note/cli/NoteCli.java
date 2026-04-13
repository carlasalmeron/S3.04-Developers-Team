package com.agenda.note.cli;

import com.agenda.note.model.Note;
import com.agenda.note.service.NoteService;
import java.util.List;
import java.util.Scanner;

public class NoteCli {

    private NoteService service;
    private Scanner scanner;

    public NoteCli(NoteService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option = -1;

        while (option != 0) {
            System.out.println("\n--- NOTES MENU ---");
            System.out.println("1. Create note");
            System.out.println("2. List all notes");
            System.out.println("3. Find note by ID");
            System.out.println("4. Delete note");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> createNote();
                case 2 -> listNotes();
                case 3 -> findNote();
                case 4 -> deleteNote();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid option, try again.");
            }
        }
    }

    private void createNote() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Content: ");
        String content = scanner.nextLine();

        service.createNote(title, content);
        System.out.println("Note created successfully.");
    }

    private void listNotes() {
        List<Note> notes = service.getAllNotes();

        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            notes.forEach(n -> System.out.println("[" + n.getId() + "] " + n.getTitle()));
        }
    }

    private void findNote() {
        System.out.print("Note ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        Note note = service.getNoteById(id);

        if (note == null) {
            System.out.println("Note not found.");
        } else {
            System.out.println("Title: " + note.getTitle());
            System.out.println("Content: " + note.getContent());
        }
    }

    private void deleteNote() {
        System.out.print("Note ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        service.deleteNote(id);
        System.out.println("Note deleted successfully.");
    }
}