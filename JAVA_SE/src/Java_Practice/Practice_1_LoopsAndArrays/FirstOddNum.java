package Java_Practice.Practice_1_LoopsAndArrays;

import java.util.Scanner;

/**
 * Created by Vitaliy on 15.12.2016.
 */
public class FirstOddNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array length: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            System.out.format("Enter %d element of array: ", i);
            arr[i] = scanner.nextInt();
        }

        System.out.println(Odd(arr));

    }

    public static int Odd(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                result = i;
                break;
            } else {
                result = -1;
            }
        }
        return result;
    }
}
