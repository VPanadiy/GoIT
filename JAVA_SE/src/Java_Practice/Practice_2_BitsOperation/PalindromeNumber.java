package Java_Practice.Practice_2_BitsOperation;

/**
 * Created by Splayd on 08.01.2017.
 * Check if number is Palindrome in 32 digit count system
 */
public class PalindromeNumber {
    public static void main(String[] args) {
        BitsPalindrome bitsPalindrome = new BitsPalindrome();
        System.out.println(bitsPalindrome.isPalindrome(10));
        System.out.println(bitsPalindrome.isPalindrome(98304));
    }
}

class BitsPalindrome {
    public boolean isPalindrome(int input) {
        boolean result = false;
        StringBuilder builder = new StringBuilder();
        int[] resultArray = new int[32];
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((mask & input) != 0) {
                resultArray[i] += 1;
            } else {
                resultArray[i] = 0;
            }
        }

        for (int elements : resultArray) {
            builder.append(elements);
        }

        String resultString = builder.reverse().toString();
        System.out.println(resultString);

        result = palindromeCheck(result, resultString);

        return result;
    }

    private boolean palindromeCheck(boolean result, String resultString) {
        StringBuilder resultBuilder = new StringBuilder(resultString);

        resultBuilder.reverse();

        if (resultString.equals(resultBuilder.toString())) {
            result = true;
        }
        return result;
    }
}