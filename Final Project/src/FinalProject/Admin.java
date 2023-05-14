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

    private Scanner input;

    public Admin() {
        input = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("Welcome, Admin. What would you like to do today?");
        System.out.println("\nHere are some options: ");
        System.out.println("1. Add an item to the shop");
        System.out.println("2. Remove an item from the shop");
        System.out.println("3. Modify the attributes of an item");
        System.out.println("4. Log out");

        int choice = getChoice();
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
//                removeProduct();
                break;
            case 3:
                modifyProduct();
                break;
            case 4:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                displayOptions();
        }
    }

    private int getChoice() {
        System.out.print("Please enter a number corresponding to an option: ");
        int choice = input.nextInt();
        input.nextLine(); //consume the newline character
        return choice;
    }

    // to add an item
    private void addProduct() {
        System.out.println("Please choose a category:");
        System.out.println("p - phones");
        System.out.println("h - headphones");
        System.out.println("t - tvs");
        System.out.println("l - laptops");

        String category = input.nextLine();

        if (category.equalsIgnoreCase("p") || category.equalsIgnoreCase("h")
                || category.equalsIgnoreCase("t") || category.equalsIgnoreCase("l")) {
            System.out.print("Enter the price of the item: ");
            double price = input.nextDouble();
            input.nextLine(); //consume the newline character

            System.out.print("Enter the name of the item: ");
            String name = input.nextLine();

            System.out.print("Enter the product ID of the item: ");
            int id = input.nextInt();
            input.nextLine(); //consume the newline character

            System.out.print("Enter the year of release of the item: ");
            int year = input.nextInt();
            input.nextLine(); //consume the newline character

            String item = category + "|" + price + "|" + name + "|" + id + "|" + year + "|";

            try {
                FileWriter writer = new FileWriter("C:\\Users\\2279307\\Desktop\\Note.txt", true);
                PrintWriter printWriter = new PrintWriter(writer);
                printWriter.println(item);
                printWriter.close();
                System.out.println("Item added successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        } else {
            System.out.println("Invalid category. Please choose a valid category.");
            addProduct();
        }

    }
    
    // to remove a product 
    public void removeItem() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the ID of the item you want to remove: ");
    int id = input.nextInt();
    input.nextLine(); 

    // search for the item with the given ID
    /*
     *  write the rest of the code here
     */
    
}

    // modify
    public void modifyProduct() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the category to modify (p, h, t, or l):");
    String category = scanner.nextLine();
    System.out.println("Enter the name of the item to modify:");
    String name = scanner.nextLine();
    System.out.println("Enter the field to modify (name, price, ID, or date):");
    String field = scanner.nextLine();
    System.out.println("Enter the new value:");
    String newValue = scanner.nextLine();

    try {
        File file = new File("C:\\Users\\2279307\\Desktop\\Note.txt");
        File tempFile = new File("ModifiedProducts.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String[] itemData = currentLine.split("\\|");
            if (itemData[0].equals(category) && itemData[2].equals(name)) {
                switch (field) {
                    case "name":
                        itemData[2] = newValue;
                        break;
                    case "price":
                        itemData[1] = newValue;
                        break;
                    case "ID":
                        itemData[3] = newValue;
                        break;
                    case "date":
                        itemData[4] = newValue;
                        break;
                    default:
                        System.out.println("Invalid field entered");
                        reader.close();
                        writer.close();
                        return;
                }
                currentLine = String.join("|", itemData);
            }
            writer.write(currentLine + "\n");
        }
        reader.close();
        writer.close();
        file.delete();
        tempFile.renameTo(file);
        System.out.println("Item modified successfully");
    } catch (IOException e) {
        System.out.println("Error modifying item: " + e.getMessage());
    }
}

}

