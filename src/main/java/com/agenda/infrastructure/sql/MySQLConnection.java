package com.agenda.infrastructure.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/agenda_db";
    private static final String USER = "DevelopersTeam";
    private static final String PASSWORD = "1234";

    private static Connection connection = null;

    private MySQLConnection() {}

    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                throw new SQLException("The MySQL driver was not found: " + e.getMessage());
            }
        }
        return connection;
    }
}
