/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

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
}
