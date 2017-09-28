package Java_Practice.Practice_2_BitsOperation;

/**
 * Created by Splayd on 04.01.2017.
 */
public class AverageNumber_Bits {
    public static void main(String[] args) {
        Average average = new Average();
        PositiveAverage positiveAverage = new PositiveAverage();
        System.out.println(average.Average(4, 6)); //5
        System.out.println(average.Average(-4, -7)); //-5
        System.out.println(average.Average(-4, 7)); //1
        System.out.println(average.Average(-2147483648, -2147483648)); //-2147483648
        System.out.println(average.Average(2147483647, 2147483647)); //2147483647
        System.out.println(average.Average(-2147483648, 2147483647)); //0
        System.out.println(average.Average(-2147483648, -2)); //-1073741825
        System.out.println(average.Average(-2147483648, 2)); //-1073741825
        System.out.println(average.Average(2147483647, 2)); //1073741824
        System.out.println(average.Average(2147483647, -2)); //-1073741822
        System.out.println(average.Average(-2147483648, -4)); //-1073741826
        System.out.println(average.Average(-2, -2147483648)); //-1073741825
        System.out.println(average.Average(2, -2147483648)); //-1073741825
        System.out.println(average.Average(2, 2147483647)); //1073741824
        System.out.println(average.Average(-2, 2147483647)); //-1073741822
        System.out.println(average.Average(-4, -2147483648)); //-1073741826
        System.out.println(average.Average(2_000, 2_000)); //2000
        System.out.println(positiveAverage.Average(2, 4));
        System.out.println(positiveAverage.Average(4, 7));
        //1000 0000 0000 0000 0000 0000 0000 0000 min
        System.out.println(Integer.MIN_VALUE);      //+
        //0111 1111 1111 1111 1111 1111 1111 1111 max
        System.out.println(Integer.MAX_VALUE);
        //1111 1111 1111 1111 1111 1111 1111 1111 -1
    }
}

class Average {
    public int Average(int a, int b) {
        if (Integer.MIN_VALUE == a && Integer.MIN_VALUE == b) {
            return Integer.MIN_VALUE;
        }
        if (Integer.MIN_VALUE == a || Integer.MIN_VALUE == b) {
            if (a < 0 && b < 0) {
                int c = (a - b) / 2;
                return c + b;
            } else {
                return (a - b) / 2;
            }
        }
        if (a < 0 && b < 0) {
            return (a + b) / 2;
        }
        return (a + b) >>> 1;
    }
}

class PositiveAverage {
    public int Average(int a, int b) {
        return (a + b) >>> 1;
    }
}
