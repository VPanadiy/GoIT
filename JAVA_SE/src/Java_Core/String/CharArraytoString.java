package Java_Core.String;

import java.util.Arrays;

/**
 * Created by Splayd on 10.12.2016.
 */
public class CharArraytoString {
    public static void main(String[] args) {
//        char[] array = new char[256];
        char[] array = {'a', 'b', 'c'};

/*        for (int i = 0; i < array.length; i++) {
            array[i] = (char) i;
        }

        for (char elements : array) {
            System.out.println(elements);
        }*/

        final String arrayString = Arrays.toString(array);
        System.out.println(arrayString);

    }
}
