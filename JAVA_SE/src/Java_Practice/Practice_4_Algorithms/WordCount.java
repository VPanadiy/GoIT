package Java_Practice.Practice_4_Algorithms;

/**
 * Created by Vitaliy on 20.01.2017.
 * Count words in String. Only that contain letters A-Z and a-z;
 */
public class WordCount {
    public static void main(String[] args) {
        CountInputWords countInputWords = new CountInputWords();
        String input = "Hello 4 my happy world!!!";
        System.out.println(countInputWords.countByBlank(input));
        String input2 = "Hello4my2happy1world!!!";
        System.out.println(countInputWords.countWordsInSingleString(input2));
    }
}

class CountInputWords {
    public int countByBlank(String input) {
        int count = 0;

        for (String word : input.split(" ")) {

            System.out.println(word);

            boolean isOnlyLetters = true;
            for (int i = 0; i < word.length(); i++) {
                if ((word.charAt(i) < 'A' || word.charAt(i) > 'Z') && (word.charAt(i) < 'a' || word.charAt(i) > 'z')) {
                    isOnlyLetters = false;
                }
            }

            if (isOnlyLetters) {
                count++;
            }
        }
        return count;
    }

    public int countWordsInSingleString(String input) {
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        boolean isSeveralSymbol = false;
        for (int i = 0; i < input.length(); i++) {
            if ((input.charAt(i) < 'A' || input.charAt(i) > 'Z') && (input.charAt(i) < 'a' || input.charAt(i) > 'z')) {
                stringBuilder.append("\n");
                if (!isSeveralSymbol) {
                    count++;
                }
                isSeveralSymbol = true;
            } else {
                isSeveralSymbol = false;
                stringBuilder.append(input.charAt(i));
            }
        }

        System.out.println(stringBuilder.toString());
        return count;
    }
}
