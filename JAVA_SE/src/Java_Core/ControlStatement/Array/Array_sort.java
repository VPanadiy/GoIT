package Java_Core.ControlStatement.Array;

import java.util.Arrays;

/**
 * Created by Splayd on 24.11.2016.
 */
public class Array_sort {
    public static void main(String[] args) {
        double[] arrayOfDouble = {1.0, 4.0, 3.0, 5.5, -6.2, 6.0};
        double[] arrayOfDouble2 = {1.0, 4.0, 3.0, 5.5, -6.2, 6.0};

        boolean swapOccurred = true;

        while(swapOccurred) {
            swapOccurred = false;
            for (int i = 0; i < arrayOfDouble.length - 1; i++) {
                if (arrayOfDouble[i] > arrayOfDouble[i + 1]) {
                    double tempVariable = arrayOfDouble[i];
                    arrayOfDouble[i] = arrayOfDouble[i + 1];
                    arrayOfDouble[i + 1] = tempVariable;
                    swapOccurred = true;
                }
            }
        }

        Arrays.sort(arrayOfDouble2); //realization of sorting array

        for (double elements : arrayOfDouble) {
            System.out.println(elements);
        }
        for (double elements : arrayOfDouble2) {
            System.out.println(elements);
        }
    }
}
