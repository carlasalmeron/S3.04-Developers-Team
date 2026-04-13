package com.agenda.note.service;

import com.agenda.note.model.Note;
import com.agenda.note.repository.NoteRepository;

import java.util.List;

public class NoteServiceImplement implements NoteService {

    private NoteRepository repository;

    public NoteServiceImplement(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createNote(String title, String content) {
        Note note = new Note(0, title, content);
        repository.save(note);
    }

    @Override
    public Note getNoteById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public void deleteNote(int id) {
        repository.delete(id);
    }
}