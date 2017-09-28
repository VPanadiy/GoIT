package Java_Practice.Practice_1_LoopsAndArrays;

/**
 * Created by Splayd on 03.01.2017.
 */
public class SnakeArray {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int exit = 0;

        for (int j = 0 + exit; j < arr.length; j++) {
            if (exit < arr.length) {
                System.out.println(arr[j][exit]);
                if (arr[j][exit] == arr[arr.length - 1][exit]) {
                    exit++;
                    if (exit < arr.length)
                        for (; j >= 0; j--) {
                            System.out.println(arr[j][exit]);
                            if (arr[j][exit] == arr[0][exit]) {
                                exit++;
                            }
                        }
                    else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }
}
