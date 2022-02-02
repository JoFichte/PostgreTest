package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {

    private static DatabaseConnection instance;

    private DatabaseConnection() {

    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    static Connection connection;

    public static boolean connectDatabase(String database, String username, String password) {

        try {
            connection = DriverManager.getConnection(
                    database,
                    username,
                    password);

            System.out.println("Database connection established");

            return true;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
