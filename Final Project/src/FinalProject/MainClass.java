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
public class MainClass {

    public static void main(String[] args) throws IOException {

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
                        System.out.println("Welcome, Admin. What would you like to do today?");
                        //code for admin --> add or remove items, edit attributes of items, or log out
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
                            categoriesOfItems();
                            String category = myInput.next();

                            //read IO file
                            ArrayList<Electronics> electronicsList = new ArrayList();
                            String fileName = "C:\\Users\\2279307\\Desktop\\Note.txt";

                            IOReader.readElectronicsFile(fileName, electronicsList);
                            String[][] data;
                            data = readDataFromFile("C:\\Users\\2279307\\Desktop\\Note.txt");

                            switch (category) {
                                case "a" -> {
                                    System.out.println("Here are the TVs in stock:");

                                    for (String[] d : data) {
                                        for (int j = 1; j < d.length; j++) {
                                            // Print each element of the array
                                            System.out.print(d[j] + " ");
                                        }
                                        // Move to a new line after each row is printed
                                        System.out.println();
                                    }
                                }
                                case "b" -> {
                                    System.out.println("Here are the phones in stock:");
                                }
                                case "c" -> {
                                    System.out.println("Here are the laptops in stock:");
                                }
                                case "d" -> {
                                    System.out.println("Here are the headphones in stock:");
                                }
                            }
                        }

                        case 2 -> {
                            System.out.print("Enter your budget: $");

                            Budget budget = new Budget(myInput.nextInt());

                            boolean quit = false;

                            // display menu until user chooses to quit/go back
                            while (!quit) {
                                if (!budgetMenu(myInput)) {  // If budget() returns false, break out of the loop
                                    break;
                                }
                                int optionBudget = myInput.nextInt();
                                modifyBudget(budget, optionBudget, myInput, quit);
                            }
                            c.setBudget(budget);
                            myInput.close();
                        }
                        case 3 -> {
                            System.out.println("You can now begin to check your cart.");
                            cart();

//            System.out.println(
//                    """
//                           1. Go back to shopping
//                           2. Continue
//                           3. Log out""");
//            int checkout = myInput.nextInt();
//            switch (checkout) {
//                case 1 -> {
//                    System.out.println("You can now begin to shop items by category.");
//                    categoriesOfItems();
//                    String category = myInput.next();
//                }
//                case 2 -> {
//                    System.out.println("You are now in checkout.");
//                    System.out.println("The total is of: ");
//                    System.out.print("Delivery (d) or pick up (p)? ");
//                    String delivOrPick = myInput.next();
//                    delivery(delivOrPick, c);
//                }
//                case 3 ->
//                    logOut();
//                default ->
//                    System.out.println("Invalid option. Please try again.");
//            }
//            System.out.println();
                        }
                        case 4 -> {
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

    // methods
    
    /*
    The main menu that is displayed at the beginning
     */
    public static void mainMenu() {
        System.out.println("""
                1. Shop items by category
                2. Set up a budget
                3. Go to cart
                4. Log out""");
        System.out.println();
    }

    /*
    User chooses which category of items they want to shop
     */
    public static void categoriesOfItems() {
        System.out.println();
        System.out.println("""
                a. TVs
                b. Phones
                c. Laptops
                d. Headphones""");
        System.out.println();
        System.out.print("Choose a category of items: ");
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
    public static void modifyBudget(Budget budget, int optionBudget, Scanner myInput, boolean quit) {
        System.out.println();
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
                quit = true;
            }

            default ->
                System.out.println("Invalid choice.");
        }
    }

    /*
    The cart of the user that will be shown when they choose to checkout
     */
    public static void cart() {
        System.out.println();
        System.out.println("Here is your cart:");
        
        //printing items chosen
        System.out.println();
        System.out.println("Would you like to proceed with the transaction?");
    }

    /*
    The delivery options 
     */
    public static void delivery(String delivOrPick, Customer c) {
        switch (delivOrPick) {
            case "d" -> {
                System.out.println("\nYour item(s) will be delivered in 3-5 business days.");
                System.out.println("Order ID: " + c.getOrderId());
            }
            case "p" -> {
                System.out.println("You can come pick up your item(s) at 4567 Hamel Street, H6R 3L2, Montreal, QC");
                System.out.println("Order ID: " + c.getOrderId());
            }
            default ->
                System.out.println("Invalid answer");
        }
        System.out.println("\nThank you for shopping at the Java ElectroShop!");
    }

    /*
    The log out menu
     */
    public static void logOut() {
        System.out.printf("\n%20s %20s\n", "Successfully logged out.", "Thank you for shopping with the Java ElectroShop!");
    }

}
