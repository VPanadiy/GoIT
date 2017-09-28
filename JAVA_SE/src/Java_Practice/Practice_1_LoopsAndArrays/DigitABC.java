package Java_Practice.Practice_1_LoopsAndArrays;

/**
 * Created by Vitaliy on 15.12.2016.
 */
public class DigitABC {
    public static void main(String[] args) {
        String s = "bcd";
        System.out.println(stringDigit(s));
    }

    public static int stringDigit(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch - 'a';
            builder.append(num);
        }
        String res = builder.toString();
        int result = Integer.parseInt(res);
        return result;
    }
}
