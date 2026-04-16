package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.NoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceImplementTest {

    @Mock
    private NoteRepository repository;

    @InjectMocks
    private NoteServiceImplement service;

    @Test
    void testCreateNote() {
        service.createNote("Title", "Content");
        verify(repository, times(1)).save(any(Note.class));
    }

    @Test
    void testGetNoteById() {
        Note note = new Note(1, "Title", "Content");
        when(repository.findById(1)).thenReturn(note);

        Note result = service.getNoteById(1);

        assertNotNull(result);
        assertEquals("Title", result.getTitle());
        verify(repository, times(1)).findById(1);
    }

    @Test
    void testGetAllNotes() {
        List<Note> notes = Arrays.asList(
                new Note(1, "N1", "C1"),
                new Note(2, "N2", "C2")
        );
        when(repository.findAll()).thenReturn(notes);

        List<Note> result = service.getAllNotes();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void testDeleteNote() {
        service.deleteNote(1);
        verify(repository, times(1)).delete(1);
    }
}
