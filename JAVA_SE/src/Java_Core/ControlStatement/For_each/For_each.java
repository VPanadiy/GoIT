package Java_Core.ControlStatement.For_each;

import java.util.Scanner;

/**
 * Created by Splayd on 24.11.2016.
 */
public class For_each {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of array size: ");
        int num = scanner.nextInt();
        scanner.close();

        int[] arrayOfInt = new int[num];
        for (int elements: arrayOfInt) {
            elements++;
            System.out.println("ArrayIndex " + elements);
        }
    }
}
