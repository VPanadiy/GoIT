package Java_Core.ExceptionExample;

import java.util.Scanner;

/**
 * Created by Vitaliy on 30.11.2016.
 */
public class ExceptionExample {
    public static void main(String[] args) {
        System.out.println("Enter your weight: ");
        final Scanner scan = new Scanner(System.in);
        final int a = scan.nextInt();

        if (a<0){
            throw new IllegalArgumentException("[Error:] Weight should be more then 0!");
        }

    }
}
