package Java_Practice.Practice_3_DataStructures;

import java.util.*;

/**
 * Created by Splayd on 09.01.2017.
 * Return index of second array that equals highest numbers;
 */

public class ArraysCompare {
    public static void main(String[] args) {
        Compare compare = new Compare();
        int[] firstArray = {5, 7, 6, 9, 4};
        int[] secondArray = {8, 5, 6, 2, 3};
        int[] result = compare.compare(firstArray, secondArray);
        for (int elements:result) {
            System.out.print(elements);
        }
    }
}

class Compare {

    int[] compare(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length];
        int[] tempResult = new int[firstArray.length];
        int[] firstSortArray = firstArray.clone();
        int[] secondSortArray = secondArray.clone();
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

        Arrays.sort(firstSortArray);
        Arrays.sort(secondSortArray);

        for (int i = 0; i < firstArray.length; i++) {
            int temp = firstSortArray[i];
            for (int j = 0; j < firstArray.length; j++) {
                if (firstArray[j] == temp) {
                    tempResult[j] = secondSortArray[i];
                }
            }
        }

        visualCompareArrayPerformance(firstArray, tempResult, map);

        for (int i = 0; i < secondArray.length; i++) {
            int temp = tempResult[i];
            for (int j = 0; j < secondArray.length; j++) {
                if (temp == secondArray[j]) {
                    result[i] = j;
                }
            }
        }
        return result; //4, 2, 1, 0, 3
    }

    private void visualCompareArrayPerformance(int[] firstArray, int[] tempResult, LinkedHashMap<Object, Object> map) {
        for (int i = 0; i < firstArray.length; i++) {
            map.put(firstArray[i], tempResult[i]);
        }
        System.out.println(map.toString());
    }
}
