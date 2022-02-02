package menu.implementation;

import menu.Menu;

import java.util.Scanner;

public class MainMenu implements Menu {

    private static MainMenu instance;

    private MainMenu() {

    }

    public static MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }

    @Override
    public void start() {
        printMenuHeader();

        Scanner sc = new Scanner(System.in);

        String menuSelection = sc.nextLine().toLowerCase();

        switch (menuSelection) {
            case "1":
                ReadMenu readMenu = new ReadMenu();
                readMenu.start();
            case "2":
                ;
            case "3":
                ;
            case "4":
                ;
            case "5":
                ;
            case "exit":
                return;
            default:
                start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("Welcome to the Database App");
        System.out.println("Please select what you want to do");
        System.out.println("1: Read entry from Database");
        System.out.println("2: Add entry to Database");
        System.out.println("3: Change entry in Database");
        System.out.println("4: Remove entry from Database");
        System.out.println("5: Read all entrys from Database");
        System.out.println("exit: Exit Application");
    }
}
