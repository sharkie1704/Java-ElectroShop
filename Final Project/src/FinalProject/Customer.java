/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.ArrayList;

/**
 *
 * @author 2279307
 */
public class Customer {

    String name;
    String address;
    int orderId;
    Budget budget;
    ArrayList<String> cart;
    double balance;
    double balanceWithTaxes;

    /*
    ** Constructor
     */
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.orderId = generateRandomId();
    }

    public Customer(String name, String address, int orderId) {
        this.name = name;
        this.address = address;
        this.orderId = orderId;
    }

    private int generateRandomId() {
        return orderId = (int) (Math.random() * 100000 + 2560);
    }

    //what are we gonna use this for? 
    public Electronics addToCart(ArrayList<Electronics> item, int num) {
        for (int i = 0; i < item.size(); i++) {
            if (item.get(i).getId() == num) {
                return item.get(i);
            }
        }
        return null;
    }

    public void printCart() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("- %14s\n", cart.get(i));
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderId() {
        return orderId;
    }

    public int setOrderId() {
        return generateRandomId();
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public ArrayList<String> getCart() {
        return cart;
    }

    public void setCart(ArrayList<String> cart) {
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public double getBalanceWithTaxes() {
        return balanceWithTaxes = balance * 1.15;
    }

}
