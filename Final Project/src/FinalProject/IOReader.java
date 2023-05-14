package FinalProject;

import java.io.*;
import java.util.*;

public class IOReader {

    public static void readElectronicsFile(String fileName, ArrayList<Electronics> electronicsList) throws IOException {
        String line = null;
        List<String> object = new ArrayList(5);
        String info = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                while (null != (line = bufferedReader.readLine())) {
                    String[] data = line.split(" ");

                    for (int i = 0; data.length > i; i++) {
                        for (int t = 0; t < data[i].length(); t++) {
                            if (data[i].charAt(t) != '|') {
                                info = info + data[i].charAt(t) + "";
                            }
                            if (data[i].charAt(t) == '|') {
                                object.add(info);
                                info = "";
                            }
                            if (object.size() == 5) {
                                switch (object.get(0)) {
                                    case "p":
                                        electronicsList.add(new Phones(Double.parseDouble(object.get(1)), object.get(2),
                                                Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                        object.clear();
                                        break;

                                    case "l":
                                        electronicsList.add(new Laptops(Double.parseDouble(object.get(1)), object.get(2),
                                                Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                        object.clear();
                                        break;

                                    case "t":
                                        electronicsList.add(new TV(Double.parseDouble(object.get(1)), object.get(2),
                                                Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                        object.clear();
                                        break;

                                    case "h":
                                        electronicsList.add(new Headphones(Double.parseDouble(object.get(1)), object.get(2),
                                                Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                        object.clear();
                                        break;

                                    default:
                                        object.clear();
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }
    }

    public static String[][] readDataFromFile(String fileName) throws IOException {
        List<String[]> data = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                data.add(parts);
            }
        }

        String[][] dataArray = new String[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i);
        }
        return dataArray;
    }

    public static void addToCartIO(double price, double balance, ArrayList<String> cart) {
        if (price <= balance) {
            balance -= price;
            cart.add(String.format("%.2f", price));
        } else {
            System.out.println("You don't have enough money to purchase this item.");
        }
    }
}
