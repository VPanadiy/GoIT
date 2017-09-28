package Java_Practice.Practice_2_BitsOperation;

/**
 * Created by Splayd on 04.01.2017.
 */
public class NumberOfBits {
    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(countBits.count(13));
    }
}

class CountBits {
    public int count(int num) {
        int result = 0;

        if (num < 0){
            num = num * -1;
            result ++;
        }

        while (num != 0) {
            if (num % 2 != 0) {
                result++;
            }
            num = num >> 1;
        }
        return result;
    }

}