package Java_Core.ControlStatement.Array;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by Splayd on 24.11.2016.
 */
public class Array_min_max {
    private int randomize;
    private static Logger log = Logger.getLogger(Array_min_max.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of array length");
        int num = scanner.nextInt();

        int[] arrayOfInt = getShodowArrays(num, 10);

        sortArrays(arrayOfInt);

        for (int elements : arrayOfInt) {
            System.out.println(elements);
        }

        getMinAndMax(arrayOfInt[num - 1], arrayOfInt);
    }

    public static void getMinAndMax(int i, int[] arrayOfInt) {
        log.info("Min value of array is: " + arrayOfInt[0]);
        log.info("Max value of array is: " + i);
    }

    private static void sortArrays(int[] arrayOfInt) {
        for (int i = 0; i < arrayOfInt.length - 1; i++) {
            if (arrayOfInt[i] > arrayOfInt[i + 1]) {
                int tempVariable = arrayOfInt[i];
                arrayOfInt[i] = arrayOfInt[i + 1];
                arrayOfInt[i + 1] = tempVariable;
            }
        }
    }

    private static int[] getShodowArrays(int num, int randomArray) {
        int[] arrayOfInt = new int[num];
        for (int i = 0; i < arrayOfInt.length - 1; i++) {
            Array_min_max randomize = new Array_min_max(num);
            int r = randomize.random(randomArray);
            arrayOfInt[i] = r;
            System.out.println("Value of array index " + i + " = " + arrayOfInt[r]);

        }
        return arrayOfInt;
    }

    public Array_min_max(int randomize) {
        this.randomize = randomize;
    }

    public static int random(int num) {
        return  (int) Math.floor(Math.random() * num);
    }

}
