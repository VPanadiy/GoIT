package Java_Core.JUnit;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Vitaliy on 28.12.2016.
 */
public class MathTest {

    private static SimpleMath simpleMath;

    @BeforeClass
    public static void setUpClass() throws Exception {
        simpleMath = new SimpleMath();
        System.out.println("Method SetUpClass called!!!");
    }

    @Test
    public void testAdd() throws Exception {
        int a = 10;
        int b = 5;

        int result = simpleMath.add(a, b);

        assertEquals(a + b, result);

    }

    @Ignore
    @Test
    public void testSub() throws Exception {
        int a = 456;
        int b = 234;

        int result = simpleMath.sub(a, b);

        assertEquals(a - b, result);

    }

    @Test
    public void testMult() throws Exception {
        int a = 55;
        int b = 34;

        int result = simpleMath.mult(a, b);

        assertEquals(a * b, result);

    }

    @Test(timeout = 1000)
    public void testMod() throws Exception {
        int a = 17;
        int b = 3;

        int result = simpleMath.mod(a, b);

        assertEquals(a % b, result);

    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDiv() throws Exception {
        int a = 17;
        int b = 3;

        int result = simpleMath.div(a, b);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown called!!!");

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("tearDownClassCalled");

    }
}