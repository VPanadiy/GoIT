package Java_Core.ControlStatement.Array;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Created by Splayd on 24.11.2016.
 */
public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of array size: ");
        int num = scanner.nextInt();
        scanner.close();

        int[] arrayOfInt = new int[num];
        for (int i = 0; i < arrayOfInt.length; i++) {
            arrayOfInt[i] = i;
            System.out.println("ArrayIndex " + i + " = " + arrayOfInt[i]);
        }

        int[] arrayOfInt1 = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arrayOfInt1));
    }
}
