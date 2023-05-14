/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import static FinalProject.IOReader.readDataFromFile;
import java.io.*;
import java.util.*;

/**
 *
 * @author 2279307
 */

/**
 * for any code containing a txt file location
 * do not forget to insert the location of the
 * txt file containing the Products that can be
 * downloaded via GitHub
 */
public class MainClass {

    public static void main(String[] args) throws IOException, EmptyCartException {

        Scanner myInput = new Scanner(System.in);
        Password p = new Password();
        System.out.print("Are you an admin? (y/n): ");
        boolean admin = myInput.nextLine().equalsIgnoreCase("y");

        /*
        Admin menu
         */
        if (admin) {
            char[] input;
            boolean passwordIsValid = false;

            do {
                System.out.print("Please enter the password: ");
                input = myInput.nextLine().toCharArray();

                if (p.isEqual(input)) {
                    System.out.println("Success! You typed the right password 😊\n");
                    myInput.close();
                    passwordIsValid = true;
                    if (passwordIsValid == true) {
                        System.out.println("Welcome, Admin. What would you like to do today?\n");
                        //call the Admin class--> add or remove items, edit attributes of items, or log out
                        Admin adminMenu = new Admin();
                        adminMenu.displayOptions();
                    }
                } else {
                    System.out.println("Invalid password. Try again.\n");
                }
            } while (!passwordIsValid);
        } else {
            /*
            Client menu
             */
            System.out.println(
                    """
                           
                Hi and welcome to the Java ElectroShop!
                           """);

            System.out.print(
                    "Enter your full name: ");
            String name = myInput.nextLine();

            System.out.print(
                    "Enter your address: ");
            String address = myInput.nextLine();
            System.out.println();

            Customer c = new Customer(name, address);

            char answer = 'y'; // initialize answer to 'y' to enter the loop for the first time
            boolean shouldContinue = true;
            try {
                do {
                    mainMenu();

                    System.out.print("Enter a number based on the previous options: ");
                    int option = myInput.nextInt();

                    switch (option) {
                        case 1 -> {
                            //read IO file
                            ArrayList<Electronics> electronicsList = new ArrayList();
                            String fileName = "C:\\Users\\2279307\\Desktop\\Note.txt";

                            IOReader.readElectronicsFile(fileName, electronicsList);
                            String[][] data;
                            data = readDataFromFile("C:\\Users\\2279307\\Desktop\\Note.txt");
                            System.out.print("\nDo you want to sort the items by price? (y/n): ");
                            String sort = myInput.next();
                            if ("y".equalsIgnoreCase(sort)) {
                                sortedShopping(c, myInput);
                            } else {
                                System.out.println("\nHere are the articles in stock:");
                                for (String[] d : data) {
                                    System.out.print("Price: $");
                                    for (int j = 1; j < d.length; j++) {
                                        // Print each element of the array
                                        System.out.print(d[j] + " ");
                                    }
                                    // Move to a new line after each row is printed
                                    System.out.println();
                                }
                                shopping(c, myInput);
                            }
                        }
                        case 2 -> {
                            System.out.print("Enter your budget: $");

                            Budget budget = new Budget(myInput.nextInt());
                            c.setBudget(budget);
                            budgetMenu(myInput);
                            int optionBudget = myInput.nextInt();
                            modifyBudget(c, budget, optionBudget, myInput);

                            c.setBudget(budget);
                        }
                        case 3 -> {
                            removeFromCart(c, myInput);
                        }
                        case 4 -> {
                            cart(c, myInput);
                        }
                        case 5 -> {
                            logOut();
                            shouldContinue = false;
                            break;
                        }
                        default -> {
                            if (option < 1 || option > 4) {
                                System.out.println("Invalid option. Please try again.");
                            } else {
                                System.out.print("Do you want to continue? Enter y for yes and any other character for no: ");
                                answer = myInput.next().charAt(0);
                                answer = Character.toLowerCase(answer);
                                if (answer != 'y') {
                                    shouldContinue = false;
                                }
                            }
                        }
                    }
                } while (shouldContinue);

            } catch (IllegalArgumentException ex) {
                System.out.println(ex);
            } catch (IOException e) {
                System.out.println("An error occurred. Please try again.");
            }
        }
    }

    /*
    The main menu that is displayed at the beginning
     */
    public static void mainMenu() {
        System.out.printf("\n%s\n", "********************************");
        System.out.print("""
                1. Shop items
                2. Set up a budget
                3. Remove items from cart
                4. Go to cart
                5. Log out""");
        System.out.printf("\n%s\n", "********************************");
    }

    /*
    The shopping menu; to add items to cart with a budget
     */
    public static void shopping(double budgetAmount, Customer c, Scanner myInput) throws IOException, EmptyCartException {
        String fileName = "C:\\Users\\2279307\\Desktop\\Note.txt";
        ArrayList<Electronics> electronicsList = new ArrayList();
        IOReader.readElectronicsFile(fileName, electronicsList);
        ArrayList<String> cartItems = new ArrayList();
        double balance = 0.00;

        boolean keepShopping = true;

        while (keepShopping) {
            System.out.printf("\n%s\n", "************************************");
            System.out.println("Select an item to add to your cart:");
            System.out.println("\n0. Exit shopping");
            for (int i = 0; i < electronicsList.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + electronicsList.get(i) + " ");
            }

            int choice = myInput.nextInt();

            if (choice == 0) {
                keepShopping = false;
            } else if (choice > 0 && choice <= electronicsList.size()) {
                Electronics item = electronicsList.get(choice - 1);
                cartItems.add(item.getName());
                balance += item.getPrice();
                System.out.println("\n" + item.getName() + " added to your cart.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nYou have selected the following items:");
        for (String item : cartItems) {
            System.out.println("- " + item);
        }
        System.out.printf("%s: $%.2f\n", "Total balance", balance);
        if (budgetAmount <= balance) {
            System.out.println("\nYou have respected your budget. Congratulations!");
        } else {
            System.out.println("\nYou have exceeded your budget. Do you wish to proceed? (y/n)");
            char proceed = (char) myInput.nextByte();
            if (proceed == 'y') {
                c.setCart(cartItems);
            } else {
                removeFromCart(c, myInput);
            }
        }
    }

    /*
    The shopping menu but without a budget
     */
    public static void shopping(Customer c, Scanner myInput) throws IOException {
        String fileName = "C:\\Users\\2279307\\Desktop\\Note.txt";
        ArrayList<Electronics> electronicsList = new ArrayList();
        IOReader.readElectronicsFile(fileName, electronicsList);
        ArrayList<String> cartItems = new ArrayList();
        double balance = 0.00;

        boolean keepShopping = true;

        while (keepShopping) {
            System.out.printf("\n%s\n", "************************************");
            System.out.println("Select an item to add to your cart:");
            System.out.println("\n0. Exit shopping");
            for (int i = 0; i < electronicsList.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + electronicsList.get(i) + " ");
            }

            int choice = myInput.nextInt();

            if (choice == 0) {
                keepShopping = false;
            } else if (choice > 0 && choice <= electronicsList.size()) {
                Electronics item = electronicsList.get(choice - 1);
                cartItems.add(item.getName());
                balance += item.getPrice();
                System.out.println("\n" + item.getName() + " added to your cart.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nYou have selected the following items:");
        for (String item : cartItems) {
            System.out.println("- " + item);
        }
        System.out.printf("%s: $%.2f\n", "Total balance", balance);
        c.setCart(cartItems);
        c.setBalance(balance);
    }

    /*
    The shopping menu if the user wants the items sorted by price
     */
    public static void sortedShopping(Customer c, Scanner myInput) throws IOException {
        String fileName = "C:\\Users\\2279307\\Desktop\\Note.txt";
        ArrayList<Electronics> electronicsList = new ArrayList();
        IOReader.readElectronicsFile(fileName, electronicsList);
        ArrayList<String> cartItems = new ArrayList();
        double balance = 0.00;

        boolean keepShopping = true;
        System.out.printf("\n%s\n", "************************************");
        System.out.println("How would you like to sort the items?");
        System.out.println("1. Sort by low to high");
        System.out.println("2. Sort by high to low");
        int sortChoice = myInput.nextInt();
        // Sort the list based on user's choice  
        switch (sortChoice) {
            case 1 ->
                Collections.sort(electronicsList, new ElectronicsLtHComparator());
            case 2 ->
                Collections.sort(electronicsList, new ElectronicsHtLComparator());
            default -> {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        while (keepShopping) {
            System.out.printf("\n%s\n", "************************************");
            System.out.println("Select an item to add to your cart:");
            System.out.println("0. Exit shopping");
            for (int i = 0; i < electronicsList.size(); i++) {
                System.out.println("\n" + (i + 1) + ". " + electronicsList.get(i) + " ");
            }

            int choice = myInput.nextInt();

            if (choice == 0) {
                keepShopping = false;
            } else if (choice > 0 && choice <= electronicsList.size()) {
                Electronics item = electronicsList.get(choice - 1);
                cartItems.add(item.getName());
                balance += item.getPrice();
                System.out.println("\n" + item.getName() + " added to your cart.");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\nYou have selected the following items:");
        for (String item : cartItems) {
            System.out.println("- " + item);
        }
        System.out.printf("%s: $%.2f\n", "Total balance", balance);
        c.setCart(cartItems);
        c.setBalance(balance);
    }

    /*
    To remove items from cart
     */
    public static void removeFromCart(Customer c, Scanner myInput) throws EmptyCartException {
        ArrayList<String> cart = c.getCart();
        if (cart.isEmpty()) {
            throw new EmptyCartException("Your cart is empty!");
        }
        System.out.printf("\n%s\n", "************************************");
        System.out.println("\nSelect an item to remove from your cart:");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i + 1) + ". " + cart.get(i));
        }

        int choice = myInput.nextInt();

        if (choice > 0 && choice <= cart.size()) {
            String item = cart.get(choice - 1);
            cart.remove(item);
            System.out.println("\n" + item + " removed from your cart.");
        } else {
            System.out.println("Invalid choice. Please try again.");
        }
    }

    /*
    The budget menu that is displayed when the user chooses the budget option
     */
    public static boolean budgetMenu(Scanner myInput) {
        System.out.println();
        System.out.print("""
        1. Add money to the budget
        2. Remove money from the budget
        3. Display the current balance
        4. Shop according to budget
                         
        What would you like to do?""" + " ");
        int option = myInput.nextInt();
        return option != 5; // If the user chooses to quit, return false
    }

    /*
    To modify the budget 
     */
    public static void modifyBudget(Customer c, Budget budget, int optionBudget, Scanner myInput) throws IOException, EmptyCartException {
        System.out.println();
        try {
            switch (optionBudget) {
                case 1 -> {
                    System.out.print("Enter the amount to add: $");
                    double addMoney = myInput.nextDouble();
                    budget.add(addMoney);
                    System.out.print("Money added successfully. ");
                    budget.displayBalance();
                }

                case 2 -> {
                    System.out.print("Enter the amount to remove: $");
                    double removeMoney = myInput.nextDouble();
                    budget.remove(removeMoney);
                    System.out.println("Money removed successfully. ");
                    budget.displayBalance();
                }

                case 3 -> {
                    budget.displayBalance();
                }

                case 4 -> {
                    shopping(budget.getBalance(), c, myInput);
                }

                default -> {
                    System.out.println("Invalid choice.");
                    break;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    /*
    The cart of the user that will be shown when they choose to checkout
     */
    public static void cart(Customer c, Scanner myInput) {
        if (c.getCart() == null) {
            System.out.println("\nYou do not have any items in your cart. What would you like to do?\n");
        } else {
            System.out.printf("\n%23s\n", "Here is your cart:");
            System.out.printf("%s\n", "****************************");
            c.printCart();

            System.out.printf("%s: $%.2f\n%s\n", "Total before taxes", c.getBalance(), "****************************");
            System.out.println();
            System.out.println("""
            1. Go back to main menu
            2. Continue
            3. Log out""");
            System.out.print("\nWhat would you like to do? ");
            int checkout = myInput.nextInt();
            switch (checkout) {
                case 3 ->
                    logOut();
                case 2 ->
                    checkout(c, myInput);
                default ->
                    System.out.println();
            }
        }
    }

    /*
    The checkout menu
     */
    public static void checkout(Customer c, Scanner myInput) {
        System.out.printf("\n%s\n", "****************************");
        System.out.printf("%s: $%.2f\n", "Total after taxes", c.getBalanceWithTaxes());
        System.out.printf("%s\n", "****************************");
        System.out.print("Delivery (d) or pick up (p)? ");
        String delivOrPick = myInput.next();
        delivery(delivOrPick, c);
        System.out.println("\nThank you for shopping at the Java ElectroShop!\n");
    }

    /*
    The delivery options 
     */
    public static void delivery(String delivOrPick, Customer c) {
        switch (delivOrPick) {
            case "d" -> {
                System.out.println("\nYour item(s) will be delivered in 3-5 business days.");
                System.out.println("Name and adress of client: " + c.getName() + "," + c.getAddress());
                System.out.println("Order ID: " + c.getOrderId());
            }
            case "p" -> {
                System.out.printf("%s\n", "******************************************");
                System.out.println("\nYou can come pick up your item(s) at 4567 Hamel Street, H6R 3L2, Montreal, QC");
                System.out.println("Name and adress of client: " + c.getName() + "," + c.getAddress());
                System.out.println("Order ID: " + c.getOrderId());
                System.out.printf("%s\n", "******************************************");
            }
            default ->
                System.out.println("Invalid answer\n");
        }
    }

    /*
    The log out menu
     */
    public static void logOut() {
        System.out.printf("\n%20s %20s\n", "Successfully logged out.", "Thank you for shopping with the Java ElectroShop!");
    }

}
