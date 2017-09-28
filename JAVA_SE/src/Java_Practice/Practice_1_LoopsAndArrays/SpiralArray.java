package Java_Practice.Practice_1_LoopsAndArrays;

/**
 * sout: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
 * Created by Vitaliy on 15.12.2016.
 */
public class SpiralArray {
    public static void main(String[] args) {

        Spiral matrix = new Spiral();

        int[][] inputArray = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };

        int[] result = matrix.resultArray(inputArray);

        for (int aResult : result) {
            System.out.print(aResult + " ");
        }
    }
}

class Spiral {
    public int[] resultArray(int[][] arr) {

        int height = arr.length;
        int weight = arr[0].length;
        int arrayLength = height * weight;
        int[] result = new int[arrayLength];

        int index = 0;

        for (int circle = 0; circle < height; circle++) {

            int horizontal;
            int vertical = circle;

            for (horizontal = circle; horizontal < weight - 1 - circle; horizontal++) {
                result[index++] = arr[vertical][horizontal];
            }

            for (vertical = circle; vertical < height - 1 - circle; vertical++) {
                result[index++] = arr[vertical][horizontal];
            }

            for (; horizontal > circle; horizontal--) {
                result[index++] = arr[vertical][horizontal];
            }

            for (; vertical > circle; vertical--) {
                result[index++] = arr[vertical][horizontal];
            }
        }

        if (height % 2 != 0 && weight % 2 != 0) {
            result[index++] = arr[height / 2][weight / 2];
        }
        return result;
    }
}
