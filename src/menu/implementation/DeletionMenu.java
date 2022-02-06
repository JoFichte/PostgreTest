package menu.implementation;

import database.DatabaseEntryRemover;
import menu.Menu;

import java.util.Scanner;

public class DeletionMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        if (id.equalsIgnoreCase("cancel"))
            MainMenu.getInstance().start();
        if (!checkId(id)) {
            System.out.println("Enter valid id numbers 0-9");
            start();
        }

        DatabaseEntryRemover databaseEntryRemover = new DatabaseEntryRemover();

        System.out.println(databaseEntryRemover.deleteDatabaseEntry(Integer.parseInt(id)) + " entries have been removed.");

        start();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("Select Entry by ID you want to delete");
        System.out.println("Enter cancel if you want to go back to main menu");
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
