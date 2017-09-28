package Java_Practice.Practice_1_LoopsAndArrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitaliy on 27.12.2016.
 */
public class Alphabet {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        ArrayList<Character> charList = new ArrayList<>();

        CreateAlphabet.CreateAlphabet(charList);

        for (char elements : charList) {
            builder.append(elements);
        }
        String input = builder.toString();

        System.out.print("Input String: ");
        System.out.println(input);

        CheckAlphabet checkAlphabet = new CheckAlphabet();
        System.out.println("Result: " + String.valueOf(checkAlphabet.check(input)));

    }
}

class CreateAlphabet {
    public static void CreateAlphabet(ArrayList<Character> charList) {
        for (int i = 0; i < 256; i++) {
            if (i >= 0 && i <= 64) {
                continue;
            } else if (i >= 91 && i <= 96) {
                continue;
            } else if (i >= 123) {
                continue;
            } else {
                charList.add((char) i);
            }
        }
    }
}

class CheckAlphabet {
    public boolean check(String input) {

        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            charSet.add(input.charAt(i));
        }

        for (int i = 0; i < 26; i++) {
            if (!charSet.contains((char) ('a' + i)) && (!charSet.contains((char) ('a' + i)))) {
                return false;
            }
        }
        return true;
    }
}

/* ******************first method**********************************

        boolean result = false;
        StringBuilder builder = new StringBuilder();

        for (char ch = 'a'; ch <= 'z';ch++) {
            if (!charSet.contains(ch)){
                result = false;
            } else {
                result = true;
            }
        }

        for (char ch = 'A'; ch <= 'Z';ch++) {
            if (!charSet.contains(ch)){
                result = false;
            } else {
                result = true;
            }
        }
*/
