/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

/**
 *
 * @author 2279307
 */
public class Customer {

    String name;
    String address;
    int orderId;
    Budget budget;

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
        int n = (int) (Math.random() * 100000 + 2560);
        return orderId = n;
    }

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
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
}
