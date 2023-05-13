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
}
