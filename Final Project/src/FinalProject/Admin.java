/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electroshop1;

import java.util.Scanner;

/**
 *
 * @author A
 */

import java.util.Scanner;

public class Admin {
    private Scanner scan = new Scanner(System.in);

    public void displayOptions() {
        System.out.println("Admin Menu");
        System.out.println("1. Add an item to the shop");
        System.out.println("2. Modify the attributes of an item");

        int choice = scan.nextInt();

        switch (choice) {
            case 1 -> {
                // code to add an item to the shop
                System.out.println("You have selected to add an item to the shop.");
            }
            case 2 -> {
                // code to modify the attributes of an item
                System.out.println("You have selected to modify the attributes of an item.");
            }
            default -> System.out.println("Invalid choice. Please choose either option 1 or 2.");
        }
    }
}
