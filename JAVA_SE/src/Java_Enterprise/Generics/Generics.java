package Java_Enterprise.Generics;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vitaliy on 17.01.2017.
 */
public class Generics {

    @Test
    public void testGenericTypeSafe() throws Exception {
        List<Integer> ints = Arrays.asList(10, 15, 20);
        for (Integer anInt : ints) {
            System.out.println(anInt);
        }
    }

    @Test
    public void testGenericSubTypes() throws Exception {
        List<Number> numbers;
        List<Integer> integers = Arrays.asList(10, 15, 20);
/*        numbers = integers;
        numbers.add(10.5);*/
    }

    @Test
    public void testArraysSubTypes() throws Exception {
        Number[] numbers;
        Integer[] integers = new Integer[]{10, 15, 20};
        numbers = integers;
        numbers[2] = 10.5;
    }
}