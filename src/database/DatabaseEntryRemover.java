package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseEntryRemover {
    public int deleteDatabaseEntry(int id) {

        int affectedRows = 0;

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement("DELETE FROM testscheme.testtable WHERE \"ID\" = ?")) {

            preparedStatement.setInt(1, id);

            affectedRows = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return affectedRows;
    }
}
