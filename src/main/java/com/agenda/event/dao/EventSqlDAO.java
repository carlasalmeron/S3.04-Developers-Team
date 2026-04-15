package com.agenda.event.dao;

import com.agenda.event.model.Event;
import com.agenda.event.repository.EventRepository;
import com.agenda.infrastructure.sql.MySQLConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventSqlDAO implements EventRepository {

    @Override
    public void save(Event event) {
        String sql = "INSERT INTO events (title, location, start_time, end_time) VALUES (?, ?, ?, ?)";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, event.getTitle());
            pstmt.setString(2, event.getLocation());

            pstmt.setTimestamp(3, Timestamp.valueOf(event.getStartTime()));
            pstmt.setTimestamp(4, Timestamp.valueOf(event.getEndTime()));

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("✅ Event successfully saved to the database!");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error saving in MySQL: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public List<Event> findAll() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";

        try (Connection conn = MySQLConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Event event = new Event.Builder()
                        .id(rs.getInt("id"))
                        .title(rs.getString("title"))
                        .location(rs.getString("location"))
                        .startTime(rs.getTimestamp("start_time").toLocalDateTime())
                        .endTime(rs.getTimestamp("end_time").toLocalDateTime())
                        .build();

                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM events WHERE id = ?";

        try (Connection conn = MySQLConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("✅ Event successfully deleted from the database!");
            } else {
                System.out.println("No events were found with the ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error deleting the event: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
