package Java_Core.ControlStatement.Array;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

/**
 * Created by Splayd on 26.11.2016.
 */
public class Array_calc {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter value of two-dimensional arrays: ");
        int num = 0;
        try {
            num = Integer.parseInt(scan.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int[][] array = new int[num][num];

        for (int i = 0; i < num; i++) {
            System.out.print("****");
        }
        System.out.print("**");
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.print("*");
            for (int j = 0; j < array.length; j++) {
                Array_calc array_calc = new Array_calc();
                int rand = array_calc.getRandomize();
                array[i][j] = rand;
                System.out.printf("%3d ", array[i][j]);
            }
            System.out.print("*");
            System.out.println(" ");
        }

        for (int i = 0; i < num; i++) {
            System.out.print("****");
        }
        System.out.print("**");
        System.out.println();

        System.out.print("Would you sort array? ");
        System.out.print("Print \"YES\" or \"NO\" : ");
        String ans;
        ans = scan.nextLine();
        switch (ans) {
            case "y": {
            }
            case "yes": {
            }
            case "Y": {
            }
            case "Yes": {
            }
            case "YES": {

                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        for (int k = 0; k < array.length - 1; k++) {
                            if (array[i][k] > array[i][k + 1]) {
                                int tempVariable = array[i][k];
                                array[i][k] = array[i][k + 1];
                                array[i][k + 1] = tempVariable;
                            }
                        }
                    }

                }

                Arrays.sort(array, new java.util.Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return Integer.compare(a[0], b[0]);
                    }
                });

                for (int i = 0; i < num; i++) {
                    System.out.print("****");
                }
                System.out.print("**");
                System.out.println();

                for (int i = 0; i < array.length; i++) {
                    System.out.print("*");
                    for (int j = 0; j < array.length; j++) {
                        System.out.printf("%3d ", array[i][j]);
                    }
                    System.out.print("*");
                    System.out.println(" ");
                }

                for (int i = 0; i < num; i++) {
                    System.out.print("****");
                }
                System.out.print("**");
                System.out.println();

                break;
            }
            case "n": {
            }
            case "no": {
            }
            case "N": {
            }
            case "No": {
            }
            case "NO": {
                System.out.println("We will just print 2d array:");
                System.out.println(Arrays.deepToString(array));
                break;
            }
            default: {
                System.out.println("Unknown command" + ans);
            }
        }

        System.out.print("Would you sum array? ");
        System.out.print("Print \"YES\" or \"NO\" : ");
        String ans2;
        ans2 = scan.nextLine();
        scan.close();
        switch (ans2) {
            case "y": {
            }
            case "yes": {
            }
            case "Y": {
            }
            case "Yes": {
            }
            case "YES": {
                int sum = 0;
                for (int row = 0; row < array.length; row++) {
                    for (int col = 0; col < array[row].length; col++) {
                        sum = sum + array[row][col];
                    }
                }
                System.out.println("Sum of 2d array is = " + sum);
                break;
            }
            case "n": {
            }
            case "no": {
            }
            case "N": {
            }
            case "No": {
            }
            case "NO": {
                System.out.println("Good bye! Come again!");
                break;
            }
            default: {
                System.out.println("Unknown command" + ans);
            }
        }
    }


    public int getRandomize() {
        return (int) (Math.floor(Math.random() * 100 + 1));
    }
}
