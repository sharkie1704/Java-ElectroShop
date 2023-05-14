/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.Scanner;

/**
 *
 * @author A
 */
public class Admin {

    Scanner scan = new Scanner(System.in);

    public void displayOptions() {
        System.out.println("Admin Menu");
        System.out.println("1. Add an item to the shop");
        System.out.println("2. Remove an item from the shop");
        System.out.println("3. Modify the attributes of an item");
        System.out.println("4. Log out");

        // Check if there is input available before calling nextInt()
        if (scan.hasNextInt()) {
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> {
                    // code to add an item to the shop
                    addProduct();
                    // chose a category + link with IO file
                }
                case 2 -> {
                    // code to remove an item from the shop
                    // chose a category + link with IO file
                }
                case 3 -> {
                    // code to modify the attributes of an item
                    // modify either price, date, etc.
                }
                case 4 -> // code to log out/ go to customer ???
                    System.out.println("You have selected to log out.");
                default ->
                    System.out.println("Invalid choice. Please choose either options.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
        }
    }
        private int getChoice() {
        System.out.print("Please enter a number corresponding to an option: ");
        int choice = input.nextInt();
        input.nextLine(); //consume the newline character
        return choice;
    }

    // to add an item
    private void addProduct() {
        System.out.println("Please choose a category:");
        System.out.println("p - phones");
        System.out.println("h - headphones");
        System.out.println("t - tvs");
        System.out.println("l - laptops");

        String category = input.nextLine();

        if (category.equalsIgnoreCase("p") || category.equalsIgnoreCase("h")
                || category.equalsIgnoreCase("t") || category.equalsIgnoreCase("l")) {
            System.out.print("Enter the price of the item: ");
            double price = input.nextDouble();
            input.nextLine(); //consume the newline character

            System.out.print("Enter the name of the item: ");
            String name = input.nextLine();

            System.out.print("Enter the product ID of the item: ");
            int id = input.nextInt();
            input.nextLine(); //consume the newline character

            System.out.print("Enter the year of release of the item: ");
            int year = input.nextInt();
            input.nextLine(); //consume the newline character

            String item = category + "|" + price + "|" + name + "|" + id + "|" + year + "|";

            try {
                FileWriter writer = new FileWriter("C:\\Users\\2279307\\Desktop\\Note.txt", true);
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.println(item);
                printWriter.close();
                System.out.println("Item added successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } else {
            System.out.println("Invalid category. Please choose a valid category.");
            addProduct();
        }

    }

}
