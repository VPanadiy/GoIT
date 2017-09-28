package Java_Practice.Practice_2_BitsOperation;

/**
 * Created by Splayd on 04.01.2017.
 */
public class AddZero_Bits {
    public static void main(String[] args) {
        SetZero setZero = new SetZero();
        System.out.println(setZero.Set(6, 3));
    }
}

class SetZero {
    public int Set(int num, int i) {
        int mask = 1 << i - 1;
        return (num & ~mask);
    }
}
