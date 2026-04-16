package com.agenda.note.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void testNoteProperties() {
        Note note = new Note(1, "Shopping List", "Milk, Bread, Eggs");

        assertAll(
                () -> assertEquals(1, note.getId()),
                () -> assertEquals("Shopping List", note.getTitle()),
                () -> assertEquals("Milk, Bread, Eggs", note.getContent())
        );

        note.setTitle("Updated List");
        note.setContent("Milk, Tea");
        note.setId(10);

        assertAll(
                () -> assertEquals(10, note.getId()),
                () -> assertEquals("Updated List", note.getTitle()),
                () -> assertEquals("Milk, Tea", note.getContent())
        );
    }
}
