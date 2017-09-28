package Java_Core.Collection;

import java.util.ArrayList;
import java.util.Collections;

import static java.util.Comparator.comparing;

/**
 * Created by Splayd on 10.12.2016.
 */
public class CollectionSort {
    public static void main(String[] args) {
        final ArrayList<Integer> num = new ArrayList<>();
        num.add(100);
        num.add(300);
        num.add(200);

        for (int nums:num) {
            System.out.println(nums);
        }
        System.out.println();
        Collections.sort(num);
        for (int nums:num) {
            System.out.println(nums);
        }

        System.out.println();
        num.add(245);
        num.add(-245);
        num.add(-45);
        num.add(645);

        num
                .stream()
                .sorted()
                .forEach(nums -> System.out.println(nums));

    }

}
