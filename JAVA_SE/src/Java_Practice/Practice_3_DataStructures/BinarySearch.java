package Java_Practice.Practice_3_DataStructures;

/**
 * Created by Splayd on 22.01.2017.
 * Search digit. If array contain search digit - return index;
 * Else - return -1 - insertionIndex, where insertionIndex is index where we can put this target;
 */
public class BinarySearch {
    public static void main(String[] args) {
        Search search = new Search();
        int[] intArray = new int[]{1, 2, 4, 5, 6, 7, 8, 9, 10};
        int target = search.find(intArray, 3);
        System.out.println(target);
    }
}

class Search {
    public int find(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;
        int middle = 0;

        while (start <= end) {
            middle = (start + end) >>> 1;

            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return -1 - start;
    }
}
