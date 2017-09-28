package Java_Core.String;

/**
 * Created by Splayd on 12.12.2016.
 */
public class String_format {
    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        System.out.format("The square root of %d is %f.%n", i , r);
    }
}
