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

    double price;
    String name;
    int id;
    int dateOfRelease;

    public ArrayList<Electronics> filtering(ArrayList data,String s) {
        Electronics thing = null;
        ArrayList<Electronics> New = null;
        String class_name;

        for(int i =0; i<data.size();i++){
            switch(s){
                case "a"->{
                    if (data.get(i) instanceof Phones){
                        New.add((Electronics) data.get(i));
                    }
                }
                case "b"->{
                    if (data.get(i) instanceof Laptops){
                        New.add((Electronics) data.get(i));
                    }
                }
                case "c"->{
                    if (data.get(i) instanceof TV){
                        New.add((Electronics) data.get(i));
                    }
                }
                case "d"->{
                    if (data.get(i) instanceof Headphones){
                        New.add((Electronics) data.get(i));
                    }
                }
            }
        }
        return New;
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
    
    class Phones extends Electronics {

        public Phones(double p, String n, int i,int d) {
            price = p;
            name = n;
            id = i;
            dateOfRelease = d;
        }
        
        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class Laptops extends Electronics {

        public Laptops(double p, String n, int i,int d) {
            price = p;
            name = n;
            id = i;
            dateOfRelease = d;
        }
        

        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class TV extends Electronics {

        public TV(double p, String n, int i,int d) {
            price = p;
            name = n;
            id = i;
            dateOfRelease = d;
        }
        

        @Override
        public String toString() {
            return String.format("%12s: %-4s%-2s%d%n%12s: %d%n%12s: %f%c",
                    "Product & id", name, "-", id,
                    "Date", dateOfRelease, "Price", price, '$');
        }
    }

    class Headphones extends Electronics {

        public Headphones(double p, String n, int i,int d) {
            price = p;
            name = n;
            id = i;
            dateOfRelease = d;
        }
        

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


