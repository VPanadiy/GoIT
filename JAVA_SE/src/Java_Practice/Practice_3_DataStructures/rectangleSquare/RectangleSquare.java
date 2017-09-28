package Java_Practice.Practice_3_DataStructures.rectangleSquare;

/**
 * Created by Splayd on 12.01.2017.
 */
public class RectangleSquare {

    public static void main(String[] args) {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0};
        int[] h = {20, 10};
        int[] w = {10, 20};
        System.out.println(squareRectangle.measure(x, h, w));
    }

    int measure(int[] x, int[] h, int[] w) {

        if (x.length == 0) {
            return 0;
        }

        int maxLength = getMaxLength(x, w);

        int sum = 0;
        for (int i = 1; i <= maxLength; i++) {

            int maxHeight = 0;
            for (int j = 0; j < x.length; j++) {

                if (i > x[j] && i <= x[j] + w[j]) {

                    if (maxHeight < h[j]) {
                        maxHeight = h[j];
                    }
                }
            }
            sum += maxHeight;
        }

        return sum;
    }

    private int getMaxLength(int[] x, int[] w) {
        int maxLength = x[0] + w[0];
        for (int i = 1; i < x.length; i++) {

            if (x[i] + w[i] > maxLength) {
                maxLength = x[i] + w[i];
            }
        }
        return maxLength;
    }
}