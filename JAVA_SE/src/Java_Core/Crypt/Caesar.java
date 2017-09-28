package Java_Core.Crypt;

import java.util.Scanner;

/**
 * Created by Splayd on 10.12.2016.
 */
public class Caesar {
    public static void main(String[] args) {
        System.out.println("Enter your message to crypt: ");
        Scanner scan = new Scanner(System.in);
        String scanString = scan.nextLine();
        System.out.println("Enter key: ");
        int key = scan.nextInt();
        scan.close();
        String crypt = Crypt(scanString, key);
        System.out.println("Your crypt message is: " + crypt);
        String decrypt = DeCrypt(crypt, key);
        System.out.println("Your decrypt message is: " + decrypt);
    }

    public static String Crypt(String scanString, int key) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = scanString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            int ascii = (int) charArray[i];
            ascii = ascii + key;
            charArray[i] = (char) ascii;
        }
        for (char elements : charArray) {
            builder.append(elements);
        }
        String builderString = builder.toString();
        return builderString;
    }

    public static String DeCrypt(String scanString, int key) {
        StringBuilder builder = new StringBuilder();
        char[] charArray = scanString.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            int ascii = (int) charArray[i];
            ascii = ascii - key;
            charArray[i] = (char) ascii;
        }
        for (char elements : charArray) {
            builder.append(elements);
        }
        String builderString = builder.toString();
        return builderString;
    }
}
