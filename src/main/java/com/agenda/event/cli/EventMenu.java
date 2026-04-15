package com.agenda.event.cli;

import com.agenda.common.utils.ConsoleInput;
import com.agenda.event.model.Event;
import com.agenda.event.service.EventService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EventMenu {
    private final EventService eventService;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public EventMenu(EventService eventService) {
        this.eventService = eventService;
    }

    public void showMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- EVENT MENU ---");
            System.out.println("1. Create Event");
            System.out.println("2. List Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Back to Main Menu");

            int option = ConsoleInput.readInt("Select an option");

            switch (option) {
                case 1:
                    createEventFlow();
                    break;
                case 2:
                    listEvents();
                    break;
                case 3:
                    deleteEvent();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
    public void createEventFlow() {
        String title = ConsoleInput.readString("Event Title: ");
        String location = ConsoleInput.readString("Location: ");

        System.out.println("Date format: yyyy-MM-dd HH:mm (Ej: 2024-12-31 23:59)");
        String startStr = ConsoleInput.readString("Start date: ");
        String endStr = ConsoleInput.readString("End date: ");

        try {
            LocalDateTime start = LocalDateTime.parse(startStr, formatter);
            LocalDateTime end = LocalDateTime.parse(endStr, formatter);

            Event newEvent = new Event.Builder()
                    .title(title)
                    .location(location)
                    .startTime(start)
                    .endTime(end)
                    .build();

            eventService.createEvent(newEvent);

        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("❌ Error: Invalid date format. Please use yyyy-MM-dd HH:mm");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Validation Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ An unexpected error occurred: " + e.getMessage());
        }
    }

    public void listEvents() {
        System.out.println("----EVENTS LIST----");
        List<Event> events = eventService.getAllEvents();

        if (events.isEmpty()) {
            System.out.println("There are no events registered.");
        } else {
            System.out.printf("%-4s | %-20s | %-15s | %-16s%n", "ID", "TITLE", "LOCATION", "START TIME");
            System.out.println("------------------------------------------------------------------");

            for (Event e : events) {
                System.out.printf("%-4d | %-20s | %-15s | %-16s%n",
                        e.getId(),
                        e.getTitle(),
                        e.getLocation(),
                        e.getStartTime().format(formatter));
            }
        }
    }

    public void deleteEvent() {
        int id = ConsoleInput.readInt("Event ID to delete");
        eventService.deleteEvent(id);

    }
}
