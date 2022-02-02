package database;

import java.sql.*;

public class AddDatabaseEntry {

    public boolean addFamilyMemberEntry(Connection con, int ID, String firstname, String lastname) {

        boolean success = false;

        try (PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO testscheme.testtable(\"ID\", firstname, lastname)" + "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, ID);
            preparedStatement.setString(2, firstname);
            preparedStatement.setString(3, lastname);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        success = true;
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            success = false;
        }

        return success;
    }
}
