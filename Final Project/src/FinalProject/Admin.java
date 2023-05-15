package FinalProject;

import java.io.*;
import java.util.*;

public class Admin {
    
    /*
    ** The admin menu of options
    */ 
    public void displayOptions() {
        System.out.printf("\n%s", "************************************************");
        System.out.println("\nWelcome, Admin. What would you like to do today?");
        System.out.print("""
                1. Add an item to the shop
                2. Remove an item from the shop
                3. Log out
                        """);
    }

    /*
    ** List of options that the admin can do
     */
    public void adminOptions(int adminChoice, Scanner input) throws IOException {
        switch (adminChoice) {
            case 1 ->
                addProduct(input);
            case 2 ->
                removeProduct(input);
            case 3 ->
                System.out.printf("\n%20s\n", "Successfully logged out.");
            default -> {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
    }

    /*
    ** To add an item
     */
    public void addProduct(Scanner input) {
        System.out.println("Please choose a category:");
        System.out.println("p - phones");
        System.out.println("h - headphones");
        System.out.println("t - tvs");
        System.out.println("l - laptops");

        String category = input.next();

        if (category.equalsIgnoreCase("p") || category.equalsIgnoreCase("h")
                || category.equalsIgnoreCase("t") || category.equalsIgnoreCase("l")) {
            System.out.print("\nEnter the price of the item: ");
            double price = input.nextDouble();

            System.out.print("Enter the name of the item: ");
            String name = input.next();

            System.out.print("Enter the product ID of the item: ");
            int id = input.nextInt();

            System.out.print("Enter the year of release of the item: ");
            int year = input.nextInt();

            String item = category + "|" + price + "|" + name + "|" + id + "|" + year + "|";

            try {
                FileWriter writer = new FileWriter("C:\\Users\\2235663\\Desktop\\Note.txt", true);
                try ( PrintWriter printWriter = new PrintWriter(writer)) {
                    printWriter.println(item);
                }
                System.out.println("Item added successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }
    }

    /*
    ** To remove an item
     */
    public void removeProduct(Scanner input) throws IOException {
        String fileName = "C:\\Users\\2235663\\Desktop\\Note.txt";
        ArrayList<Electronics> electronicsList = new ArrayList();
        IOReader.readElectronicsFile(fileName, electronicsList);

        System.out.printf("\n%s\n", "************************************");
        for (int i = 0; i < electronicsList.size(); i++) {
            System.out.println("\n" + (i + 1) + ". " + electronicsList.get(i) + " ");
        }

        System.out.print("Enter the ID of the item you want to remove: ");
        int id = input.nextInt();
        input.nextLine(); //consume the newline character

        try {
            File inputFile = new File("C:\\Users\\2235663\\Desktop\\Note.txt");
            File tempFile = new File("temp.txt");
            BufferedWriter writer;
            try ( BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                writer = new BufferedWriter(new FileWriter(tempFile));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] itemData = line.split("\\|");
                    int itemID = Integer.parseInt(itemData[3]);
                    if (itemID != id) {
                        writer.write(line + "\n");
                    }
                }
            }
            writer.close();
            if (!inputFile.delete()) {
                System.out.println("Could not delete file.");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename file.");
            }
            System.out.println("Item removed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
