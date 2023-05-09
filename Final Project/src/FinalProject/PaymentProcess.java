/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electroshop1;

import java.util.*;

/**
 *
 * @author A
 */

/* the psvm is to be removed as this is a simple class
 * which will be later implemented in the main 
 */
public class PaymentProcess {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // initialize budget object with $1000
        Budget budgetObject = new Budget(1000);

        System.out.print("Enter the item price: $");
        double price = scan.nextDouble();

        if (price <= budgetObject.getBalance()) {
            System.out.println("You have enough money to buy this item.");
            System.out.print("Confirm transaction? (Y/N): ");
            String confirm = scan.next();

            if (confirm.equalsIgnoreCase("Y")) {
                budgetObject.remove(price);
                System.out.println("Transaction complete.");
                System.out.print("Current balance: ");
                budgetObject.displayBalance();
            } else {
                System.out.println("Transaction canceled.");
            }
        } else {
            System.out.println("You do not have enough money to buy this item.");
        }

        scan.close();
    }
}
