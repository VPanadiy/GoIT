package Java_Core.OOP.ClassExamples;

import java.util.Scanner;

/**
 * Created by Splayd on 23.11.2016.
 */
public class Radius {

    final private static double PI = 3.14;
    private double radius;


    public static void main(String[] args) {
        double radius1 = 0;
        double radius2 = 0;

        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter value of first circle radius: ");
            radius1 = scanner.nextDouble();
            System.out.println("Enter value of second circle radius: ");
            radius2 = scanner.nextDouble();
        } catch (Exception e){
            System.out.println(e);
        }


        Radius countRadius1 = new Radius(radius1);
        double circle1 = countRadius1.area();
        Radius countRadius2 = new Radius(radius2);
        double circle2 = countRadius2.area();



        System.out.println("Radius of first circle is: " + circle1);
        System.out.println("Radius of second circle is: " + circle2);
        System.out.println(maxWithTwoRadios(circle1, circle2));
    }

    public Radius(Double radius) {
        this.radius = radius;
    }

    public double area() {
        return PI * radius * radius;
    }

    public static double maxWithTwoRadios(double a, double b){
        return (a>b) ? a : b;
    }
}
