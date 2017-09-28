package Java_Core.Collection;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Splayd on 04.12.2016.
 */
public class CollectionExample {
    public static void main(String[] args) {
        Integer[] arrayOfInt = {45, -25, 64};

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arrayOfInt));
        arrayList.add(100);

        System.out.println("Arrays elements: ");
        for (Integer elements: arrayList) {
            System.out.println(elements);
        }

        System.out.println("Size of array list: " + arrayList.size());
    }
}
