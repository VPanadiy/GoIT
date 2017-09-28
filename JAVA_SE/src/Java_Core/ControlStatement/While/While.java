package Java_Core.ControlStatement.While;

import java.util.Scanner;

/**
 * Created by Splayd on 23.11.2016.
 */
public class While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the value of number a: ");
        int a = scanner.nextInt();
        System.out.println("Enter the value of number b: ");
        int b = scanner.nextInt();

        while (a > b){
            a--;
            System.out.println("Number a = " + a);
        }

        do{
            a++;
            System.out.println("Number a = " + a);
        } while (a < b);
    }
}
