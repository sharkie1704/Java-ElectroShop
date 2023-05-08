/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.*;
/**
 *
 * @author Heidi
 */

public class Budget {
    private double balance;

    // initialize balance w/ constructor
    public Budget(double balance) {
        this.balance = balance;
    }

    // add money mtd
    public void add(double amount) {
        balance += amount;
    }

    // remove money mtd
    public void remove(double amount) {
        balance -= amount;
    }

    // display balance mtd
    public void displayBalance() {
        System.out.println("Current balance: $" + String.format("%.2f", balance));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // for user to enter budget
        double budget = 0;
        boolean validBudget = false;
        while (!validBudget) {
            System.out.print("Please enter your budget: $");
            try {
                budget = scan.nextDouble();
                validBudget = true;
            } catch (InputMismatchException e) { /*Exception handling*/
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        //initialize budget object
        Budget budgetObject = new Budget(budget);

        boolean quit = false;

        // display menu 'til user chooses to quit/ go back
        while (!quit) {
            System.out.println("\nWhat would you like to do: ");
            System.out.println("1 - Add money to the budget");
            System.out.println("2 - Remove money from the budget");
            System.out.println("3 - Display the current balance");
            System.out.println("4 - Go back to the previous page");

            int option = 0;
            boolean validOption = false;
            while (!validOption) {
                try {
                    option = scan.nextInt();
                    validOption = true;
                } catch (InputMismatchException e) { /*Exception handling*/
                    System.out.println("Invalid input. Please enter a number.");
                    scan.nextLine();
                }
            }

            // switch case depending on user choice
            switch (option) {
                case 1 -> {
                    double addMoney = 0;
                    boolean validAddMoney = false;
                    while (!validAddMoney) {
                        System.out.print("Enter the amount to add: $");
                        try {
                            addMoney = scan.nextDouble();
                            validAddMoney = true;
                        } catch (InputMismatchException e) { /*Exception handling*/
                            System.out.println("Invalid input. Please enter a number.");
                            scan.nextLine();
                        }
                    }
                    budgetObject.add(addMoney);
                    System.out.println("Money added successfully.");
                    budgetObject.displayBalance();
                }

                case 2 -> {
                    double removeMoney = 0;
                    boolean validRemoveMoney = false;
                    while (!validRemoveMoney) {
                        System.out.print("Enter the amount to remove: $");
                        try {
                            removeMoney = scan.nextDouble();
                            validRemoveMoney = true;
                        } catch (InputMismatchException e) { /*Exception handling*/
                            System.out.println("Invalid input. Please enter a number.");
                            scan.nextLine();
                        }
                    }
                    budgetObject.remove(removeMoney); 
                    System.out.println("Money removed successfully.");
                    budgetObject.displayBalance();
                }

                case 3 -> budgetObject.displayBalance();

                case 4 -> quit = true;

                default -> System.out.println("Invalid choice.");
            }
        }
        scan.close();
    }
}
