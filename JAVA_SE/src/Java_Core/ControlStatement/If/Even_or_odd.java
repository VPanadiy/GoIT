package Java_Core.ControlStatement.If;

import java.util.Scanner;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Even_or_odd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int number = scanner.nextInt();
        scanner.close();

        if (number %2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }

}
