package Java_Core.String;

/**
 * Created by Splayd on 10.12.2016.
 */
public class Palindrome {
    public static void main(String[] args) {
        String palindrome = "moom";
        char charArray[] = palindrome.toCharArray();
        boolean isPalindrome = true;

        for (int i = 0; i < charArray.length / 2; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }


}
