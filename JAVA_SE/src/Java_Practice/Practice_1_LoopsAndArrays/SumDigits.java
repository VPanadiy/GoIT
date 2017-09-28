package Java_Practice.Practice_1_LoopsAndArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Vitaliy on 15.12.2016.
 */
public class SumDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String num = bufferedReader.readLine();

        char[] arrChar = num.toCharArray();
        int[] arrInt = new int[arrChar.length];
        int sum = 0;

        for (int i = 0; i < arrChar.length; i++) {
            arrInt[i] = arrChar[i] - 48;
            sum = sum + arrInt[i];

        }

        for (int elements : arrInt) {
            System.out.println(elements);
        }

        System.out.println(sum);
    }
}
