package Java_Practice.Practice_1_LoopsAndArrays;

import java.util.Scanner;

/**
 * Created by Vitaliy on 15.12.2016.
 */
public class ConcatDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array length: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.format("Enter %d element of array: ", i);
            arr[i] = scanner.nextInt();
        }

        System.out.println(Concat(arr));
    }

    public static StringBuilder Concat(int[] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(arr[i]);
        }
        return builder;
    }
}
