package com.agenda.event.service;

import com.agenda.event.model.Event;
import com.agenda.event.repository.EventRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventServiceTest {

    @Mock
    private EventRepository repository;

    @InjectMocks
    private EventService service;

    @Test
    void testCreateValidEvent() {
        LocalDateTime now = LocalDateTime.now();
        Event event = new Event.Builder()
                .title("Conference")
                .startTime(now)
                .endTime(now.plusHours(2))
                .build();

        service.createEvent(event);

        verify(repository, times(1)).save(event);
    }

    @Test
    void testCreateInvalidEvent() {
        LocalDateTime now = LocalDateTime.now();
        
        Event event = mock(Event.class);
        when(event.getStartTime()).thenReturn(now.plusHours(1));
        when(event.getEndTime()).thenReturn(now);

        service.createEvent(event);

        verify(repository, never()).save(any());
    }

    @Test
    void testGetAllEvents() {
        List<Event> events = Arrays.asList(mock(Event.class), mock(Event.class));
        when(repository.findAll()).thenReturn(events);

        List<Event> result = service.getAllEvents();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testDeleteEvent() {
        service.deleteEvent(1);
        verify(repository, times(1)).delete(1);
    }
}
