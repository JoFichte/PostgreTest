package database;

import data.FamilyMember;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDatabaseEntry {

    public List<FamilyMember> readFamilyMemberEntryById(int id) {
        return readDatabaseEntry("SELECT * from testscheme.testtable WHERE \"ID\" = ?", id);
    }

    public List<FamilyMember> readFamilyMemberEntryByFirstName(String firstName) {
        return readDatabaseEntry("SELECT * from testscheme.testtable WHERE firstname = ?", firstName);
    }

    public List<FamilyMember> readFamilyMemberEntryByLastName(String lastName) {
        return readDatabaseEntry("SELECT * from testscheme.testtable WHERE lastname = ?", lastName);
    }

    private List<FamilyMember> readDatabaseEntry(String sql, String searchCriteria) {
        List<FamilyMember> familyMember = new ArrayList<>();

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, searchCriteria);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    familyMember.add(new FamilyMember(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return familyMember;
    }

    private List<FamilyMember> readDatabaseEntry(String sql, int searchCriteria) {
        List<FamilyMember> familyMember = new ArrayList<>();

        try (PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, searchCriteria);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    familyMember.add(new FamilyMember(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return familyMember;
    }
}
