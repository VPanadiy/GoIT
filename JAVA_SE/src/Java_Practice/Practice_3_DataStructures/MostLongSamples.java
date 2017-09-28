package Java_Practice.Practice_3_DataStructures;

/**
 * Created by Splayd on 15.01.2017.
 * Found length of max samples, that different between each others on 0 or 1;
 */
public class MostLongSamples {
    public static void main(String[] args) {
        FindSamples findSamples = new FindSamples();
        int[] input = {1, 2, 2, 2, 1, 3, 4, 5};
        System.out.println(findSamples.find(input));
    }
}

class FindSamples {
    public int find(int[] arrayOfSamples) {
        int[] lengthFound = new int[arrayOfSamples.length];
        for (int i = 0; i < arrayOfSamples.length; i++) {
            int count = 0;
            int temp = arrayOfSamples[i];
            for (int j = 1; j < arrayOfSamples.length; j++) {
                if (temp - arrayOfSamples[j] == 1 || temp - arrayOfSamples[j] == 0 || temp - arrayOfSamples[j] == -1) {
                    count++;
                }
            }
            lengthFound[i] = count;
        }

        int max = lengthFound[0];
        for (int i = 1; i < lengthFound.length; i++) {
            if (lengthFound[i] > max) {
                max = lengthFound[i];
            }
        }
        return max;
    }
}

