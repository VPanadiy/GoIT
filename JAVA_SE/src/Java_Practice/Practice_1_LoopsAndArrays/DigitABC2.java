package Java_Practice.Practice_1_LoopsAndArrays;

/**
 * Created by Vitaliy on 15.12.2016.
 */
public class DigitABC2 {
    public static void main(String[] args) {
        String s = "bcd";
        System.out.println(stringDigit(s));
    }

    public static int stringDigit(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int num = ch - 'a';
            result = result * 10 + num; //12+3+4=19 12*10+3=123*10+4=1234
        }
        return result;
    }
}
