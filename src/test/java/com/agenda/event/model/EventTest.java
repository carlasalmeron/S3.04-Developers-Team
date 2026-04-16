package com.agenda.event.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void testValidEventCreation() {
        LocalDateTime start = LocalDateTime.now().plusHours(1);
        LocalDateTime end = start.plusHours(2);

        Event event = new Event.Builder()
                .id(1)
                .title("Meeting")
                .location("Office")
                .startTime(start)
                .endTime(end)
                .build();

        assertAll(
                () -> assertEquals(1, event.getId()),
                () -> assertEquals("Meeting", event.getTitle()),
                () -> assertEquals("Office", event.getLocation()),
                () -> assertEquals(start, event.getStartTime()),
                () -> assertEquals(end, event.getEndTime())
        );
    }

    @Test
    void testEmptyTitleValidation() {
        LocalDateTime now = LocalDateTime.now();
        Event.Builder builder = new Event.Builder()
                .startTime(now)
                .endTime(now.plusHours(1));

        assertThrows(IllegalArgumentException.class, () -> builder.title(null).build());
        assertThrows(IllegalArgumentException.class, () -> builder.title("").build());
    }

    @Test
    void testMissingDatesValidation() {
        Event.Builder builder = new Event.Builder().title("Important Event");

        assertThrows(IllegalArgumentException.class, builder::build);
    }

    @Test
    void testInvalidDateRangeValidation() {
        LocalDateTime start = LocalDateTime.now().plusHours(2);
        LocalDateTime end = start.minusHours(1);

        Event.Builder builder = new Event.Builder()
                .title("Invalid Event")
                .startTime(start)
                .endTime(end);

        assertThrows(IllegalArgumentException.class, builder::build);
    }
}
