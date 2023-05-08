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
public class Electronics {

    double price;
    String name;
    int id;
    int dateOfRelease;

    public Electronics filtering(String s) {
        Electronics thing = null;
        if ("a".equals(s)) { //phones
            if (thing instanceof Phones) {
                return thing;
            }
        }

        if ("b".equals(s)) { //laptops
            if (thing instanceof Laptops) {
                return thing;
            }
        }

        if ("c".equals(s)) { //tvs
            if (thing instanceof TV) {
                return thing;
            }
        }

        if ("d".equals(s)) { //headphones
            if (thing instanceof Headphones) {
                return thing;
            }
        }
        return null;
    }

    class Phones extends Electronics {

        public Phones() {
        }

        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class Laptops extends Electronics {

        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class TV extends Electronics {

        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class Headphones extends Electronics {

        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class Customer {

        String Addresse;
        String Name;
        ArrayList<Electronics> Cart;

        public Customer(String Addresse, String Name) {
            this.Addresse = Addresse;
            this.Name = Name;
        }

        public static Electronics AddCart(ArrayList<Electronics> thing, int numb) {
            for (int i = 0; i < thing.size(); i++) {
                if (thing.get(i).getId() == numb) {
                    return thing.get(i);
                }
            }
            return null;
        }
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

    public int getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(int dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
