package Java_Core.String;

/**
 * Created by Splayd on 10.12.2016.
 */
public class ConvertCharArrays {
    public static void main(String[] args) {

        char[] charArray = {'a', 'b', 'c', 'd'};

        StringBuilder builder = new StringBuilder();

        for (char value : charArray) {
            builder.append(value);
        }

        System.out.println(builder.toString());
    }
}
