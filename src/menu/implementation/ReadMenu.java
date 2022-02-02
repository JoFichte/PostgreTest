package menu.implementation;

import data.FamilyMember;
import database.DatabaseConnection;
import database.ReadDatabaseEntry;
import menu.Menu;

import java.util.List;
import java.util.Scanner;

public class ReadMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);

        String menuSelection = sc.nextLine();

        menuSelection.toLowerCase();

        switch (menuSelection) {
            case "1":
                readEntryById().stream().forEach(System.out::println);
                start();
            case "2":
                readEntryByFirstName().stream().forEach(System.out::println);
                start();
            case "3":
                readEntryByLastName().stream().forEach(System.out::println);
                start();
            case "back":
                MainMenu.getInstance().start();
            default:
                start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("Enter read method");
        System.out.println("1: Read entry by ID");
        System.out.println("2: Read entry by first name");
        System.out.println("3: Read entry by last name");
        System.out.println("Back: Back to Main Menu");
    }

    private List<FamilyMember> readEntryById() {
        System.out.println("Enter ID you want to read");
        Scanner sc = new Scanner(System.in);
        String idSelection = sc.nextLine();

        ReadDatabaseEntry readDatabaseEntry = new ReadDatabaseEntry();
        return readDatabaseEntry.readFamilyMemberEntryById(DatabaseConnection.getInstance().getConnection(), Integer.parseInt(idSelection));
    }

    private List<FamilyMember> readEntryByFirstName() {
        System.out.println("Enter first name you want to read");
        Scanner sc = new Scanner(System.in);
        String firstName = sc.nextLine();

        ReadDatabaseEntry readDatabaseEntry = new ReadDatabaseEntry();
        return readDatabaseEntry.readFamilyMemberEntryByFirstName(DatabaseConnection.getInstance().getConnection(), firstName);
    }

    private List<FamilyMember> readEntryByLastName() {
        System.out.println("Enter last name you want to read");
        Scanner sc = new Scanner(System.in);
        String lastName = sc.nextLine();

        ReadDatabaseEntry readDatabaseEntry = new ReadDatabaseEntry();
        return readDatabaseEntry.readFamilyMemberEntryByLastName(DatabaseConnection.getInstance().getConnection(), lastName);
    }
}
