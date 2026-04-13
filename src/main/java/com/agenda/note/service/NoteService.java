package com.agenda.note.service;

import com.agenda.note.model.Note;

import java.util.List;

public interface NoteService {
    void createNote(String title, String content);

    Note getNoteById(int id);

    List<Note> getAllNotes();

    void deleteNote(int id);
}