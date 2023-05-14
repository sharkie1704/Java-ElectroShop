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
abstract public class Electronics {

    double price = 0.00;
    String name;
    int id;
    int yearOfRelease;

    public Electronics() {
    }

    public Electronics(double price, String name, int id, int yearOfRelease) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.yearOfRelease = yearOfRelease;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

}

class Phones extends Electronics {

    public Phones() {
    }

    public Phones(double price, String name, int id, int yearOfRelease) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                "Product & id", name, "-", id,
                "Date", yearOfRelease, "Price", price, '$');
    }
}

class Laptops extends Electronics {

    public Laptops() {
    }

    public Laptops(double price, String name, int id, int yearOfRelease) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                "Product & id", name, "-", id,
                "Date", yearOfRelease, "Price", price, '$');
    }
}

class TV extends Electronics {

    public TV() {
    }

    public TV(double price, String name, int id, int yearOfRelease) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                "Product & id", name, "-", id,
                "Date", yearOfRelease, "Price", price, '$');
    }
}

class Headphones extends Electronics {

    public Headphones() {
    }

    public Headphones(double price, String name, int id, int yearOfRelease) {
        this.price = price;
        this.name = name;
        this.id = id;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                "Product & id", name, "-", id,
                "Date", yearOfRelease, "Price", price, '$');
    }
}
