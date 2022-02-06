package menu.implementation;

import data.FamilyMember;
import database.DatabaseEntryUpdater;
import menu.Menu;

import java.util.Scanner;

public class UpdateMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();
        DatabaseEntryUpdater databaseEntryUpdater = new DatabaseEntryUpdater();

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        if (id.equalsIgnoreCase("cancel"))
            MainMenu.getInstance().start();

        if (!checkId(id)) {
            System.out.println("Enter valid id (one number from 0-9)");
            start();
        }

        System.out.println("Chose if you want to update first or last name");
        System.out.println("1: first name");
        System.out.println("2: last name");

        String updateOption = sc.nextLine();
        if (updateOption.equalsIgnoreCase("1")) {
            System.out.println("Enter new first name");
            String newFirstName = sc.nextLine();
            databaseEntryUpdater.updateFirstName(Integer.parseInt(id), newFirstName);
        }
        if (updateOption.equalsIgnoreCase("2")) {
            System.out.println("Enter new last name");
            String newFirstName = sc.nextLine();
            databaseEntryUpdater.updateLastName(Integer.parseInt(id), newFirstName);
        }

        MainMenu.getInstance().start();
    }

    @Override
    public void printMenuHeader() {
        System.out.println("Select entry you want to update by ID");
        System.out.println("1: ID");
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
}
