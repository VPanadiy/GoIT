package Java_Practice.Practice_2_BitsOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Splayd on 07.01.2017.
 */
public class Digits36_bits {
    public static void main(String[] args) {
        AddNumberBase36 addNumberBase36 = new AddNumberBase36();
        System.out.println(addNumberBase36.add("9", "1"));
        System.out.println(addNumberBase36.add("z", "1"));

    }
}

class AddNumberBase36 {
    public String add(String a, String b) {
        StringBuilder result = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int temp = 0;

        Map<Character, Integer> abc = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            abc.put((char) ('0' + i), i);
        }
        for (int i = 0; i < 26; i++) {
            abc.put((char) ('a' + i), i + 10);
            abc.put((char) ('A' + i), i + 10);
        }

        for (int i = 0; i < aLength || i < bLength; i++) {
            char aTemp = (i < aLength) ? a.charAt(aLength - 1 - i) : '0';
            char bTemp = (i < bLength) ? b.charAt(bLength - 1 - i) : '0';

            int sum = temp + abc.get(aTemp) + abc.get(bTemp);

            if (sum < 36) {
                result.append(fromInt(sum));
                temp = 0;

            } else {
                result.append(fromInt(sum % 36));
                temp = 1;
            }
        }

        if (temp == 1) {
            result.append('1');
        }

        return result.reverse().toString();
    }

    private char fromInt(int num) {
        if (num < 10) {
            return (char) ('0' + num);
        } else {
            return (char) ('a' + num - 10);
        }
    }
}
