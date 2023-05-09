/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electroshop1;
import java.util.Scanner;

/**
 *
 * @author A
 */

public class Password {
    
    private static final char[] PASSWORD = {'p', 'a', 'n', 'd', 'a'};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Are you an admin? (y/n): ");
        boolean admin = scanner.nextLine().equalsIgnoreCase("y");

        // if you're admin 
        if (admin) {
            System.out.print("Please enter the password: ");
            char[] input = scanner.nextLine().toCharArray();
            if (isEqual(input, PASSWORD)) {
                System.out.println("Success! You typed the right password 😊");
            } else { 
                System.out.println("Invalid password. Try again.");
            }
            java.util.Arrays.fill(input, '0');
        } else {
            System.out.println("Welcome to ! You do not need a password to continue.");
        }
    }

    private static boolean isEqual(char[] a, char[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}

