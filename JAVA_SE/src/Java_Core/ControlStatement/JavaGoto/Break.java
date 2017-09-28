package Java_Core.ControlStatement.JavaGoto;

/**
 * Created by Splayd on 28.11.2016.
 */
public class Break {
    public static void main(String[] args) {
        int i = 0;
        int y = 6;
        while (i < y){
            if (i == 3) {
                break;
            }
            i++;
            System.out.println("I equal = " + i);
        }
    }
}
