package database;

import data.FamilyMember;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDatabaseEntry {

    public FamilyMember readFamilyMemberEntryById(Connection con, int id) {


        FamilyMember familyMember = null;

        try (PreparedStatement preparedStatement = con.prepareStatement("SELECT * from testscheme.testtable WHERE \"ID\" = ?")) {

            preparedStatement.setInt(1, id);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    familyMember = new FamilyMember(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return familyMember;
    }

    public FamilyMember readFamilyMemberEntryByFirstName(Connection con, String firstName) {


        FamilyMember familyMember = null;

        try (PreparedStatement preparedStatement = con.prepareStatement("SELECT * from testscheme.testtable WHERE firstname = ?")) {

            preparedStatement.setString(1, firstName);


            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    familyMember = new FamilyMember(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return familyMember;
    }

    public List<FamilyMember> readFamilyMemberEntryByLastName(Connection con, String lastName) {


        List<FamilyMember> familyMember = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.prepareStatement("SELECT * from testscheme.testtable WHERE lastname = ?")) {

            preparedStatement.setString(1, lastName);


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
