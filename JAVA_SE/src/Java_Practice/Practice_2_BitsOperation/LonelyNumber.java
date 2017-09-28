package Java_Practice.Practice_2_BitsOperation;

/**
 * Created by Splayd on 08.01.2017.
 * Find lonely number in array where all numbers repeat 5 times
 */
public class LonelyNumber {
    public static void main(String[] args) {
        int[] arrOfInt = {1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5, 5, 5, 5, 5};
        FindLonelyNumber findLonelyNumber = new FindLonelyNumber();
        System.out.println(findLonelyNumber.find(arrOfInt));
    }
}

class FindLonelyNumber {
    public int find(int[] input) {
        int[] sums = new int[32];
        for (int i = 0; i < input.length; i++) {
            int num = input[i];
            for (int j = 0; j < 32; j++) {
                int mask = 1 << j;
                if ((num & mask)!=0){
                    sums[j] += 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < sums.length; i++) {
            result <<= 1;
            result += sums[sums.length-1-i]%5;
        }
        return result;
    }
}
