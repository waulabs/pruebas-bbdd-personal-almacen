package org.alvarowau.stockroomsandbox.bbdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionDemo {

    public static void main(String[] args) {
        MysqlConnection mysqlConnection = new MysqlConnection();

        // Obtener la conexión
        Connection connection = mysqlConnection.getDatabaseConnection();

        try {
            // Ejemplo de cómo usar la conexión: ejecutar una consulta simple
            String query = "SELECT * FROM Customer";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Procesa cada fila de resultados
                System.out.println("ID: " + resultSet.getInt("idCustomer"));
                System.out.println("Nombre: " + resultSet.getString("firstName"));
                System.out.println("Apellido: " + resultSet.getString("lastName"));
            }

            // Cierra los recursos de Statement y ResultSet
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error Code: " + e.getErrorCode());
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());  // Usamos el método de impresión de errores
        } finally {
            // Cierra la conexión
            mysqlConnection.closeDatabaseConnection();
        }
    }
}
