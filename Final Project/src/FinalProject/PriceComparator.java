/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FinalProject;

import java.util.Comparator;

/**
 *
 * @author 2279307
 */
public class PriceComparator implements Comparator<Electronics> {

    @Override
    public int compare(Electronics e1, Electronics e2) {
        if (e1.getPrice() < e2.getPrice()) {
            return -1;
        } else if (e1.getPrice() > e2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
