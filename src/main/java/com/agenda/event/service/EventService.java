package com.agenda.event.service;

import com.agenda.event.model.Event;
import com.agenda.event.repository.EventRepository;

import java.util.List;

public class EventService {

    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public void createEvent(Event event) {
        if (event.getEndTime().isBefore(event.getStartTime())) {
            System.out.println("Error: The event cannot end before it starts.");
            return;
        }
        repository.save(event);
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }

    public void deleteEvent(int id) {
        repository.delete(id);
    }
}
