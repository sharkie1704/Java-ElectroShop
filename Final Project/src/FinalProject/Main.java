/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.*;

/**
 *
 * @author 2279307
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("""
                           Hi and welcome to the Java ElectroShop!
                           """);
        Scanner myInput = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = myInput.nextLine();

        System.out.print("Enter your address: ");
        String address = myInput.nextLine();
        System.out.println("");

        Customer c = new Customer(name, address);

        char answer;
        try {
            do {
                mainMenu();

                System.out.print("Enter a number based on the previous options: ");
                int option = myInput.nextInt();

                switch (option) {
                    case 1 -> {

                        categoriesOfItems();
                        String category = myInput.next();
                        Electronics item = new Electronics();
                        item.filtering(category);
                    }
                    case 2 -> {
                        System.out.println("You can now begin to set up a budget.");
                        System.out.print("Enter your budget: $");

                        //Initialize object budget
                        Budget budget = new Budget(myInput.nextInt());

                        System.out.println("Is this correct?");
                        budget.displayBalance();
                        //calling budget method that filters items
                        boolean quit = false;

                        // display menu 'til user chooses to quit/ go back
                        while (!quit) {
                            budget();
                            int optionBudget = myInput.nextInt();
                            budget(budget, optionBudget, myInput, quit);
                        }
                        c.setBudget(budget);
                        myInput.close();
                    }
                    case 3 -> {
                        System.out.println("You can now begin to check your cart.");
                        cart();
                    }
                    case 4 ->
                        logOut();
                    default ->
                        System.out.println("Invalid option. Please try again.");
                }

                System.out.print("Do you want to continue? Enter y for yes and any other character for no: ");
                answer = myInput.next().charAt(0);
                answer = Character.toLowerCase(answer);
            } while (answer == 'y');

        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            e.printStackTrace();
        } finally {
            myInput.close();
        }

        //Cart and checkout
        cart();

        System.out.println("""
                           1. Go back to shopping
                           2. Continue
                           3. Log out""");
        int checkout = myInput.nextInt();
        switch (checkout) {
            case 1 -> {
                System.out.println("You can now begin to shop items by category.");
                categoriesOfItems();
                String category = myInput.next();
            }
            case 2 -> {
                System.out.println("You are now in checkout");
                System.out.println("The total is of: ");
                System.out.print("Delivery (d) or pick up (p)? ");
                String delivOrPick = myInput.next();
                delivery(delivOrPick);
            }
            case 3 ->
                logOut();
            default ->
                System.out.println("Invalid option. Please try again.");
        }
        System.out.println();
    }

    // methods
    public static void mainMenu() {
        System.out.println("""
                1. Shop items by category
                2. Set up a budget
                3. Go to cart
                4. Log out""");
        System.out.println("");
    }

    public static void budget() {
        System.out.println("""
                            1. Add money to the budget
                            2. Remove money from the budget
                            3. Display the current balance
                            4. Shop according to budget
                            5. Go back to the previous page
        What would you like to do? """);
    }

    public static void budget(Budget budget, int optionBudget, Scanner myInput, boolean quit) {
        switch (optionBudget) {
            case 1 -> {
                System.out.print("Enter the amount to add: $");
                double addMoney = myInput.nextDouble();
                budget.add(addMoney);
                System.out.print("Money added successfully. Here is your new balance: ");
                budget.displayBalance();
            }

            case 2 -> {
                System.out.print("Enter the amount to remove: $");
                double removeMoney = myInput.nextDouble();
                budget.remove(removeMoney);
                System.out.println("Money removed successfully.");
                budget.displayBalance();
            }

            case 3 ->
                budget.displayBalance();

            case 4 ->
                quit = true;

            default ->
                System.out.println("Invalid choice.");
        }
    }

    public static void logOut() {
        System.out.printf("%20s %20s", "Successfully logged out.", "Thank you for shopping with the Java ElectroShop!");
    }

    public static void categoriesOfItems() {
        System.out.println("");
        System.out.println("""
                a. TVs
                b. Phones
                c. Laptops
                d. Headphones""");
        System.out.print("Choose an option: ");
    }

    public static void cart() {
        System.out.println("");
        System.out.println("Here is your cart:");

        //printing items chosen
        System.out.println("");
        System.out.println("Would you like to proceed with the transaction?");
    }

    public static void delivery(String delivOrPick) {
        switch (delivOrPick) {
            case "d" -> {
                System.out.print("Your item(s) will be delivered in 3-5 business days.");
            }
            case "p" -> {
                System.out.println("You can come pick up your item(s) at 4567 Hamel Street, H6R 3L2, Montreal, QC");
                System.out.println("Order ID: ");
            }
            default ->
                System.out.println("Invalid answer");
        }
        System.out.println();
        System.out.println("Thank you for shopping at the Java ElectroShop!");
    }
}
