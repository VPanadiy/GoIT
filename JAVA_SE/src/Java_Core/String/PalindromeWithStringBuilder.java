package Java_Core.String;

/**
 * Created by Splayd on 10.12.2016.
 */
public class PalindromeWithStringBuilder {
    public static void main(String[] args) {
        String palindrome = "moom";

        StringBuilder builder = new StringBuilder(palindrome);

        builder.reverse();

        if (palindrome.equals(builder.toString())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }
}
