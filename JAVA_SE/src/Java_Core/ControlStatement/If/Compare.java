package Java_Core.ControlStatement.If;

import java.util.Scanner;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Compare {

    final public static double PI = 3.14;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of first circle radius: ");
        double radius1 = scanner.nextDouble();
        System.out.println("Enter value of second circle radius: ");
        double radius2 = scanner.nextDouble();
        scanner.close();

        double circle1 = PI * radius1*radius1;
        double circle2 = PI * radius2*radius2;

        if (circle2 > circle1){
            System.out.println("Second circle is bigger");
        } else if (circle2 < circle1){
            System.out.println("First circle is bigger");
        } else {
            System.out.println("Circle are equals");
        }
    }

}
