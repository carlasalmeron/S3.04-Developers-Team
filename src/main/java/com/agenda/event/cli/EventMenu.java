package com.agenda.event.cli;

import com.agenda.common.utils.ConsoleInput;
import com.agenda.event.model.Event;
import com.agenda.event.service.EventService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EventMenu {
    private final EventService eventService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public EventMenu(EventService eventService) {
        this.eventService = eventService;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- EVENT MANAGER ---");
            System.out.println("1. Create Event");
            System.out.println("2. List Events");
            System.out.println("3. Back to Main Menu");

            int option = ConsoleInput.readInt("Select an option");

            switch (option) {
                case 1:
                    createEventFlow();
                    break;
                case 2:
                    listEvents();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public void createEventFlow() {
        String title = ConsoleInput.readString("Event Tittle");
        String location = ConsoleInput.readString("Location");

        System.out.println("Date format: yyyy-MM-dd HH:mm (Ej: 2024-12-31 23:59)");
        String startStr = ConsoleInput.readString("Start date");
        String endStr = ConsoleInput.readString("End date");

        try {
            LocalDateTime start = LocalDateTime.parse(startStr, formatter);
            LocalDateTime end = LocalDateTime.parse(endStr, formatter);

            Event newEvent = new Event(title, location, start, end);
            eventService.createEvent(newEvent);
        } catch (Exception e) {
            System.out.println("Error: Incorrect date format.");
        }
    }

    public void listEvents() {
        System.out.println("----EVENTS LIST----");
        var events = eventService.getAllEvents();

        if (events.isEmpty()) {
            System.out.println("There are no events registered.");
        } else {
            for (Event e : events) {
                System.out.println(e.getId() + " | " + e.getTitle() + " | " + e.getLocation() + " | " + e.getStartTime());
            }
        }
    }
}
