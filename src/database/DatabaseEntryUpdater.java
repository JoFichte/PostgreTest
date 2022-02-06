package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseEntryUpdater {
    public int updateFirstName(int id, String firstName) {

        int affectedRows = 0;

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE testscheme.testtable SET firstname = ? WHERE \"ID\" = ?")) {

            preparedStatement.setString(1, firstName);
            preparedStatement.setInt(2, id);

            affectedRows = preparedStatement.executeUpdate();

            System.out.println("Update successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return affectedRows;
    }

    public int updateLastName(int id, String lastName) {

        int affectedRows = 0;

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement("UPDATE testscheme.testtable SET lastname = ? WHERE \"ID\" = ?")) {

            preparedStatement.setString(1, lastName);
            preparedStatement.setInt(2, id);

            affectedRows = preparedStatement.executeUpdate();

            System.out.println("Update successful");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return affectedRows;
    }
}
