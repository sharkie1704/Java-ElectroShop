package FinalProject;

import java.util.Comparator;

/*
* Compare from highest to lowest
*/
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

/*
* Compare from lowest to highest
*/
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
