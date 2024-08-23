package org.alvarowau.stockroomsandbox.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    private Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3306/prueba-store";  // Database URL
    private static final String USER = "root";  // Database user
    private static final String PASSWORD = "";  // Database password

    public MysqlConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
        } catch (SQLException e) {
            printSQLExceptionDetails(e);
        }
    }

    public Connection getDatabaseConnection() {
        return connection;
    }

    public void closeDatabaseConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed successfully.");
            }
        } catch (SQLException e) {
            printSQLExceptionDetails(e);
        }
    }

    private void printSQLExceptionDetails(SQLException e) {
        System.out.println("Error Code: " + e.getErrorCode());
        System.out.println("Cause: " + e.getCause());
        System.out.println("Message: " + e.getMessage());
    }

}
