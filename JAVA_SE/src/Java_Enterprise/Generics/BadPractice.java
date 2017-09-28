package Java_Enterprise.Generics;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vitaliy on 18.01.2017.
 */
public class BadPractice {
    @Test
    public void testPairTriple() throws Exception{
        Triple<String, Pair<String,String>, Triple<String, Long, Long>> result = new Triple();
        result.first = "This is a bad idea";
        result.second = new Pair<>();
        result.second.first = "Nightmare";
        result.second.second = "Looks awful";
        result.third = new Triple<>();
        result.third.first = "Ohh man!";
        result.third.second = 10L;
        result.third.third = 100L;

        // a lot of code here
    }

    public static class Pair<F,S>{
        public F first;
        public S second;
    }

    public static class Triple<F,S,T>{
        public F first;
        public S second;
        public T third;
    }
}
