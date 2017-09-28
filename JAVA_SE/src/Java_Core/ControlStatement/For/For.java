package Java_Core.ControlStatement.For;

import java.util.Scanner;

/**
 * Created by Splayd on 23.11.2016.
 */
public class For {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of the loop: ");
        int num = scanner.nextInt();

        for (int i = 1; i < num + 1; i++) {
            System.out.println("Loop " + i + " = " + i);
        }
    }
}
