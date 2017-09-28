package Java_Core.String;

import java.util.Arrays;

/**
 * Created by Splayd on 10.12.2016.
 */
public class BasicStringOperations {
    public static void main(String[] args) {
        final char[] charArrayToString = {'a','r','r','a','y'};
        final String stringToDisplay = Arrays.toString(charArrayToString)
                .replace("[","")
                .replace("]","")
                .replace(",","")
                .replace(" ", "")
                .trim(); //trim empty cells et end

        System.out.println(stringToDisplay);

        String s1 = "ab";
        String s2 = "ac";
        System.out.println(s1.compareTo(s2));

        s1 = s1.concat(s2);
        System.out.println(s1);

        if (s1.equals(s2)){
            System.out.println("Equal!");
        }else {
            System.out.println("Not equal!");
        }

        float fl;
        String str= "0.44";
        fl = Float.valueOf(str);
        System.out.println(fl+0.3f);
        str = String.valueOf(fl);
        System.out.println(str+" this is string");
    }
}
