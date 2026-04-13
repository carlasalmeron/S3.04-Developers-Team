package com.agenda.note.repository;
import com.agenda.note.model.Note;
import java.util.List;

public class NoteRepositoryImplement implements NoteRepository {

    @Override
    public void save(Note note) {
        // INSERT INTO notes (title, content) VALUES (?, ?)
        // El ID lo gestiona MySQL con AUTO_INCREMENT, no lo pasamos
        throw new UnsupportedOperationException("Pending MySQL connection");
    }

    @Override
    public Note findById(int id) {
        // SELECT * FROM notes WHERE id = ?
        throw new UnsupportedOperationException("Pending MySQL connection");
    }

    @Override
    public List<Note> findAll() {
        // SELECT * FROM notes
        throw new UnsupportedOperationException("Pending MySQL connection");
    }

    @Override
    public void delete(int id) {
        // DELETE FROM notes WHERE id = ?
        throw new UnsupportedOperationException("Pending MySQL connection");
    }
}