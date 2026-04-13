package com.agenda.note.repository;

import com.agenda.note.model.Note;
import java.util.List;

public interface NoteRepository {
    void save(Note note);
    Note findById(int id);
    List<Note> findAll();
    void delete(int id);
}