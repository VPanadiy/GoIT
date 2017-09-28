package Java_Practice.Practice_2_BitsOperation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Splayd on 08.01.2017.
 * Sum of 2 num in binary number system (two method)
 */

public class SumDigits {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.add("101001101010", "1110100"));
        System.out.println(addBinary.add("0", "0"));
        System.out.println(addBinary.add("", ""));
        System.out.println(addBinary.add2("101001101010", "1110100"));
        System.out.println(addBinary.add2("0", "0"));
        System.out.println(addBinary.add2("", ""));
    }
}


class AddBinary {
    // First work method
    public String add(String first, String second) {
        ArrayList<Character> charArrayOfFirst = new ArrayList<>();
        ArrayList<Character> charArrayOfSecond = new ArrayList<>();
        ArrayList<Character> resultArray = new ArrayList<>();

        for (int j = 0; j < first.length(); j++) {
            charArrayOfFirst.add(first.charAt(j));
        }

        for (int j = 0; j < second.length(); j++) {
            charArrayOfSecond.add(second.charAt(j));
        }

        if (charArrayOfFirst.size() >= charArrayOfSecond.size()) {
            int arrLen = charArrayOfFirst.size() - charArrayOfSecond.size();
            for (int i = 0; i < arrLen; i++) {
                charArrayOfSecond.add(0, '0');
            }
        } else {
            int arrLen = charArrayOfSecond.size() - charArrayOfFirst.size();
            for (int i = 0; i < arrLen; i++) {
                charArrayOfFirst.add(0, '0');
            }
        }

        int temp = 0;
        for (int i = charArrayOfFirst.size() - 1; i >= 0; i--) {
            if (((int) charArrayOfFirst.get(i) - 48) + ((int) charArrayOfSecond.get(i) - 48) + temp == 2) {
                resultArray.add('0');
                temp = 1;
            } else if (((int) charArrayOfFirst.get(i) - 48) + ((int) charArrayOfSecond.get(i) - 48) + temp > 2) {
                resultArray.add('1');
                temp = 1;
            } else if (((int) charArrayOfFirst.get(i) - 48) + ((int) charArrayOfSecond.get(i) - 48) + temp == 1) {
                resultArray.add('1');
                temp = 0;
            } else {
                resultArray.add('0');
                temp = 0;
            }
        }
        if (temp != 0) {
            resultArray.add((char) (temp + 48));
        }

        Collections.reverse(resultArray);

        String result = resultArray.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "");

        return result;
    }

    // Second work method
    public String add2(String a, String b) {

        StringBuilder result = new StringBuilder();
        int i = 0;
        int aLength = a.length();
        int bLength = b.length();
        int temp = 0;

        while (i < aLength || i < bLength) {

            char aTemp = (i < aLength) ? a.charAt(aLength - 1 - i) : '0';
            char bTemp = (i < bLength) ? b.charAt(bLength - 1 - i) : '0';

            int sum = (aTemp - '0') + (bTemp - '0') + temp;

            if (sum == 0) {
                result.append('0');

            } else if (sum == 1) {
                result.append('1');
                temp = 0;

            } else if (sum == 2) {
                result.append('0');
                temp = 1;

            } else if (sum == 3) {
                result.append('1');
                temp = 1;
            }

            i++;
        }

        if (temp == 1) {
            result.append('1');
        }

        return result.reverse().toString();
    }
}