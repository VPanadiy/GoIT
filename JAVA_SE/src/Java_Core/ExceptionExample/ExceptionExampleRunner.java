package Java_Core.ExceptionExample;

import java.util.Scanner;

/**
 * Created by Vitaliy on 29.11.2016.
 */
public class ExceptionExampleRunner {
    public static void main(String[] args) {
        System.out.println("Hello! Please enter your age: ");
        final Scanner scan = new Scanner(System.in);

        final String userInput = scan.next();

        try{
            final int age = Integer.parseInt(userInput);
            if (age < 0) {
                throw new Java_Core.ExceptionExample.NegativeAgeException(age);
            }
            System.out.println("Your age is " + age);
        } catch (NumberFormatException ex){
            System.out.println("[Error:] Value is not valid");
        } catch (Java_Core.ExceptionExample.NegativeAgeException e) {
            System.out.println("[Error:]Entered age is '"+ e.getAgeValue() +"' .Age can not be negative");
        }
    }
}
