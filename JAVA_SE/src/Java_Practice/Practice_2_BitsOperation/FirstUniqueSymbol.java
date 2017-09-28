package Java_Practice.Practice_2_BitsOperation;

import java.util.ArrayList;

/**
 * Created by Splayd on 07.01.2017.
 * First Unique char, if none then null
 */
public class FirstUniqueSymbol {
    public static void main(String[] args) {
        UniqueSymbol uniqueSymbol = new UniqueSymbol();
        System.out.println(uniqueSymbol.uniqueSymbol("google"));
    }
}

class UniqueSymbol {
    public char uniqueSymbol(String word) {
        char result = '\u0000';
        ArrayList<Character> charArray = new ArrayList<>();


        for (int i = 0; i < word.length(); i++) {
            charArray.add(word.charAt(i));
        }

        for (int i = 0; i < charArray.size(); i++) {
            char temp = charArray.get(i);
            charArray.remove(i);
            if (!charArray.contains(temp)) {
                result = temp;
            }
            charArray.add(i, temp);
        }
        return result;
    }
}