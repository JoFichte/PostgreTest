package menu.implementation;

import data.FamilyMember;
import database.AddDatabaseEntry;
import menu.Menu;

import java.util.Scanner;

public class NewEntryMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        if (id.equalsIgnoreCase("cancel"))
            MainMenu.getInstance().start();

        if (!checkId(id)) {
            System.out.println("Enter valid id (one number from 0-9)");
            start();
        }

        System.out.println("2: First name");
        String firstName = sc.nextLine();
        if (firstName.equalsIgnoreCase("cancel"))
            MainMenu.getInstance().start();
        if (!checkName(firstName)) {
            System.out.println("Enter valid name");
            start();
        }

        System.out.println("3: Last name");
        String lastName = sc.nextLine();
        if (lastName.equalsIgnoreCase("cancel"))
            MainMenu.getInstance().start();
        if (!checkName(lastName)) {
            System.out.println("Enter valid name");
            start();
        }

        FamilyMember familyMember = new FamilyMember(Integer.parseInt(id), firstName, lastName);

        writeNewDatabaseEntry(familyMember);


        MainMenu.getInstance().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("Enter family member you want to add");
        System.out.println("Enter cancel if you want to go back to main menu");
        System.out.println("1: ID");
    }

    private void writeNewDatabaseEntry(FamilyMember familyMember) {
        AddDatabaseEntry addDatabaseEntry = new AddDatabaseEntry();
        addDatabaseEntry.addFamilyMemberEntry(familyMember);
    }

    private boolean checkId(String id) {
        if (id.isEmpty())
            return false;
        if (id.length()>1)
            return false;
        if (!id.matches(".*\\d+.*"))
            return false;

        return true;
    }

    private boolean checkName(String name) {
        if (name.matches("[a-zA-Z]+"))
            return true;

        return false;
    }
}
