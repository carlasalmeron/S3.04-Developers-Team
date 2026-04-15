package com.agenda.event.repository;

import com.agenda.event.model.Event;
import java.util.List;

public interface EventRepository {

    void save(Event event);
    List<Event> findAll();
    void delete(int id);

}
