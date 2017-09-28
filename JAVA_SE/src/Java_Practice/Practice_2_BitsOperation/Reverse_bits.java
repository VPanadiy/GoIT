package Java_Practice.Practice_2_BitsOperation;

/**
 * Created by Splayd on 07.01.2017.
 * Reverse number in 32 digit count system
 */
public class Reverse_bits {
    public static void main(String[] args) {
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(-1));
    }
}

class Reverse {
    public int reverse(int input) {
        int result = 0;
        StringBuilder builder = new StringBuilder();
        int[] resultArray = new int[32];
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((mask & input) != 0) {
                resultArray[i] += 1;
            } else {
                resultArray[i] = 0;
            }
        }

        for (int elements : resultArray) {
            builder.append(elements);
        }

        System.out.println(builder);
        result = Integer.parseInt(builder.toString(), 2);

        return result;
    }
}


