package mahasiswislipapp.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private final String databaseUrl;
    private final String username;
    private final String password;

    public Database(String databaseName, String username, String password, String host, String port) {
        this.databaseUrl = "jdbc:mysql://" + host + ":" + port + "/" + databaseName;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(databaseUrl, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database: " + e.getMessage(), e);
        }
    }

    public void setup() {
        try (Connection connection = getConnection()) {
            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            System.out.println("Error setting up the database: " + e.getMessage());
        }
    }
}
