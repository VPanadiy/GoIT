package Java_Core.ControlStatement.JavaGoto;

/**
 * Created by Splayd on 28.11.2016.
 */
public class Continued {
    public static void main(String[] args) {
        int i = 0;
        int y = 6;
        while (i < y) {
            i++;
            if (i == 4) {
                continue;
            }
            System.out.println("I equals = " + i);
        }
    }
}
