package Java_Core.JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Vitaliy on 28.12.2016.
 */
@RunWith(value = Parameterized.class)
public class ParametrizedMathTest {

    private static final SimpleMath simpleMath = new SimpleMath();
    ;
    private int numberA;
    private int numberB;
    private int expected;

    public ParametrizedMathTest(int numberA, int numberB, int expected) {
        this.numberA = numberA;
        this.numberB = numberB;
        this.expected = expected;
    }

    //Declare parametrize here
    @Parameterized.Parameters(name = "{index}: multiply({0}*{1})={2}")
    //if parameters is "[3, 4, 12]", then index = test run # (from 0), {0} = 3, {1} = 4, {2} = 12.
    public static Iterable<Object[]> getParametrizedData() {
        return Arrays.asList(new Object[][]{
                {1, initSecondParametrAsTwoDimensionalArray(), initializeExpectedValueOfTest()},
                {2, 2, 4},
                {8, 2, 16},
                {4, 5, 20}
        });
    }

    private static Object[][] initSecondParametrAsTwoDimensionalArray() {
        return new Object[][]{{1}, {1}};
    }

    private static ArrayList<String> initializeExpectedValueOfTest() {
        return new ArrayList<String>();
    }

    @Test()
    public void testMult() {
        Assert.assertEquals(expected, simpleMath.mult(numberA, numberB));
    }

}