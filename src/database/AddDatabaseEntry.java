package database;

import data.FamilyMember;

import java.sql.*;

public class AddDatabaseEntry {

    public void addFamilyMemberEntry(FamilyMember familyMember) {


        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement("INSERT INTO testscheme.testtable(\"ID\", firstname, lastname)" + "VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, familyMember.getId());
            preparedStatement.setString(2, familyMember.getFirstName());
            preparedStatement.setString(3, familyMember.getLastName());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        System.out.println("Entry successfully added");
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
