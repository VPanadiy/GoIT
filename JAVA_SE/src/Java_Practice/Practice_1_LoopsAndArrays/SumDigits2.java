package Java_Practice.Practice_1_LoopsAndArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vitaliy on 15.12.2016.
 */
public class SumDigits2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        System.out.println(Sum(num));
    }

    public static int Sum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num = num / 10;
        }
        return Math.abs(sum);
    }
}

