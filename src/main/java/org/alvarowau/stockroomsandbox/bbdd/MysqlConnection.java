package org.alvarowau.stockroomsandbox.bbdd;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class MysqlConnection {

    private static HikariDataSource dataSource;

    static {
        // Configura el pool de conexiones HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/prueba-store");
        config.setUsername("root");
        config.setPassword("root");

        // Opcional: Configuraciones adicionales
        config.setMaximumPoolSize(10); // Número máximo de conexiones en el pool
        config.setMinimumIdle(5); // Número mínimo de conexiones inactivas
        config.setIdleTimeout(30000); // Tiempo máximo que una conexión puede estar inactiva
        config.setConnectionTimeout(30000); // Tiempo máximo de espera para obtener una conexión

        // Inicializa el datasource
        dataSource = new HikariDataSource(config);
        System.out.println("Database connection pool established successfully.");
    }

    public Connection getDatabaseConnection() throws SQLException {
        // Devuelve una conexión del pool
        return dataSource.getConnection();
    }

    public void close() {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("Database connection pool closed successfully.");
        }
    }
}
