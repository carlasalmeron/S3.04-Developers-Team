package com.agenda.note.repository;

import com.agenda.infrastructure.sql.MySQLConnection;
import com.agenda.note.model.Note;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NoteRepositoryImplement implements NoteRepository {

    @Override
    public void save(Note note) {
        String query = "INSERT INTO notes (title, content) VALUES (?, ?)";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, note.getTitle());
            preparedStatement.setString(2, note.getContent());
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public Note findById(int id) {
        String query = "SELECT * FROM notes WHERE id = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Note(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                );
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Note> findAll() {
        List<Note> noteList = new ArrayList<>();
        String query = "SELECT * FROM notes";

        try (Connection connection = MySQLConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                noteList.add(new Note(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("content")
                ));
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return noteList;
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM notes WHERE id = ?";

        try (Connection connection = MySQLConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}