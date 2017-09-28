package Java_Practice.Practice_4_Algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Splayd on 11.01.2017.
 */
public class ValueOfChainBuilding_Recursion {
    public static void main(String[] args) {
        ColorChain colorchain = new ColorChain();
        System.out.println(colorchain.count(35));
    }
}

class ColorChain {

    Map<Integer, Integer> map = new HashMap<>();

    {
        //Block initialize (call once)
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 4);
        map.put(-1, 0);
        map.put(-2, 0);
        map.put(-3, 0);
    }

    public int count(int N) {

        if (map.containsKey(N)) {
            return map.get(N);
        }

        int whiteFirst = count(N - 1);
        int yellowFirst = count(N - 2);
        int redFirst = count(N - 3);

        int result = whiteFirst + yellowFirst + redFirst;

        map.put(N, result);

        return result;
    }
}