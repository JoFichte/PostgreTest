package database;

import data.FamilyMember;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDatabaseEntry {

    public List<FamilyMember> readFamilyMemberEntryById(Connection con, int id) {
        return readDatabaseEntry(con, "SELECT * from testscheme.testtable WHERE \"ID\" = ?", id);
    }

    public List<FamilyMember> readFamilyMemberEntryByFirstName(Connection con, String firstName) {
        return readDatabaseEntry(con, "SELECT * from testscheme.testtable WHERE firstname = ?", firstName);
    }

    public List<FamilyMember> readFamilyMemberEntryByLastName(Connection con, String lastName) {
        return readDatabaseEntry(con, "SELECT * from testscheme.testtable WHERE lastname = ?", lastName);
    }

    private List<FamilyMember> readDatabaseEntry(Connection con, String sql, String searchCriteria) {
        List<FamilyMember> familyMember = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

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

    private List<FamilyMember> readDatabaseEntry(Connection con, String sql, int searchCriteria) {
        List<FamilyMember> familyMember = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {

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
