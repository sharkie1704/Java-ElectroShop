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
//High to Low
class ElectronicsHtLComparator implements Comparator<Electronics> {

    @Override
    public int compare(Electronics o1, Electronics o2) {
        if (o1.price == o2.price) {
            return 0;
        } else if (o1.price < o2.price) {
            return 1;
        } else {
            return -1;
        }
    }
}

//Low to High
class ElectronicsLtHComparator implements Comparator<Electronics> {

    @Override
    public int compare(Electronics o1, Electronics o2) {
        if (o1.price == o2.price) {
            return 0;
        } else if (o1.price > o2.price) {
            return 1;
        } else {
            return -1;
        }
    }
}

