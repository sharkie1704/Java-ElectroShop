/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.io.*;
import java.util.*;

/**
 *
 * @author 2280592
 */
public class IOReader {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Ntela\\Desktop\\Note.txt";
        String line = null;
        List<String> object = new ArrayList<String>(5);
        ArrayList products = new ArrayList();
        String info = "";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

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
                                case "p" -> {
                                    products.add(new Phones(Double.parseDouble(object.get(1)), object.get(2),
                                             Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                    object.clear();
                                }

                                case "l" -> {
                                    products.add(new Laptops(Double.parseDouble(object.get(1)), object.get(2),
                                             Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                    object.clear();
                                }

                                case "t" -> {
                                    products.add(new TV(Double.parseDouble(object.get(1)), object.get(2),
                                             Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                    object.clear();
                                }

                                case "h" -> {
                                    products.add(new Headphones(Double.parseDouble(object.get(1)), object.get(2),
                                             Integer.parseInt(object.get(3)), Integer.parseInt(object.get(4))));
                                    object.clear();
                                }

                                default ->
                                    object.clear();
                            }
                        }

                    }

                }

            }
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
        }

    }
}
