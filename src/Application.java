import database.DatabaseConnection;
import menu.implementation.MainMenu;

import java.sql.Connection;

public class Application {

    public static Connection connection;

    public static void main(String[] args) {

        DatabaseConnection.connectDatabase("jdbc:postgresql://localhost:8001/Testdb", "postgres", "password1234");

        MainMenu.getInstance().start();
    }
}
