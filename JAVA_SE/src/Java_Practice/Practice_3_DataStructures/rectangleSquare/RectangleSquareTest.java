package Java_Practice.Practice_3_DataStructures.rectangleSquare;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Splayd on 30.04.2017.
 */
public class RectangleSquareTest {

    @Test
    public void testZero() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {};
        int[] h = {};
        int[] w = {};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(0, result);
    }

    @Test
    public void testWPos2() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {1};
        int[] h = {5};
        int[] w = {1};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(5, result);
    }

    @Test
    public void testNotSeparateSquare() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {5, 15};
        int[] h = {10, 10};
        int[] w = {5, 5};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(100, result);
    }

    @Test
    public void testNotFromZero() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {5, 10};
        int[] h = {10, 15};
        int[] w = {6, 5};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(125, result);
    }

    @Test
    public void testMirrorPosition() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {5, 0};
        int[] h = {10, 15};
        int[] w = {5, 6};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(130, result);
    }

    @Test
    public void testMirrorPosition2() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {5, 0};
        int[] h = {10, 5};
        int[] w = {5, 6};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(75, result);
    }

    @Test
    public void test0() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0};
        int[] h = {20};
        int[] w = {10};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(200, result);
    }

    @Test
    public void testPos1() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 2};
        int[] h = {20, 5};
        int[] w = {10, 5};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(200, result);
    }

    @Test
    public void testPos2() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 2, 1};
        int[] h = {20, 5, 7};
        int[] w = {10, 5, 7};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(200, result);
    }

    @Test
    public void testPos3() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 2, 1, 3};
        int[] h = {20, 5, 7, 3};
        int[] w = {10, 5, 7, 1};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(200, result);
    }

    @Test
    public void testPos4() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 2, 1, 3, 2, 0};
        int[] h = {20, 5, 7, 3, 25, 25};
        int[] w = {10, 5, 7, 1, 4, 10};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(250, result);
    }

    @Test
    public void testPos5() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 2, 1, 3, 2, 0};
        int[] h = {20, 25, 5, 7, 3, 25, 25};
        int[] w = {10, 10, 5, 7, 1, 4, 10};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(250, result);
    }

    @Test
    public void testPos6() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 2, 1, 3, 2, 0, 5};
        int[] h = {20, 25, 5, 7, 3, 25, 25, 5};
        int[] w = {10, 10, 5, 7, 1, 4, 10, 10};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(275, result);
    }

    @Test
    public void testPos7() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 2, 1, 3, 2, 0, 5, 2};
        int[] h = {20, 25, 5, 7, 3, 25, 25, 5, 10};
        int[] w = {10, 10, 5, 7, 1, 4, 10, 10, 9};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(280, result);
    }

    @Test
    public void testPos8() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 2, 1, 3, 2, 0, 5, 2, 5};
        int[] h = {20, 5, 7, 3, 25, 25, 5, 10, 30};
        int[] w = {10, 5, 7, 1, 4, 10, 10, 9, 15};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(575, result);
    }

    @Test
    public void test1() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0};
        int[] h = {20, 10};
        int[] w = {10, 20};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(300, result);
    }

    @Test
    public void test2() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5};
        int[] h = {20, 10, 15};
        int[] w = {10, 20, 10};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(325, result);
    }

    @Test
    public void test3() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10};
        int[] h = {20, 10, 15, 5};
        int[] w = {10, 20, 10, 5};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(325, result);
    }

    @Test
    public void test4() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10, 0};
        int[] h = {20, 10, 15, 5, 5};
        int[] w = {10, 20, 10, 5, 20};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(325, result);
    }

    @Test
    public void test5() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10, 0, 0};
        int[] h = {20, 10, 15, 5, 5, 20};
        int[] w = {10, 20, 10, 5, 20, 20};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(400, result);
    }

    @Test
    public void test6() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10, 0, 0, 0};
        int[] h = {20, 10, 15, 5, 5, 20, 30};
        int[] w = {10, 20, 10, 5, 20, 20, 5};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(450, result);
    }

    @Test
    public void test7() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10, 0, 0, 0, 0};
        int[] h = {20, 10, 15, 5, 5, 20, 30, 5};
        int[] w = {10, 20, 10, 5, 20, 20, 5, 30};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(500, result);
    }

    @Test
    public void test8() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10, 0, 0, 0, 0, 0};
        int[] h = {20, 10, 15, 5, 5, 20, 30, 5, 30};
        int[] w = {10, 20, 10, 5, 20, 20, 5, 30, 15};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(600, result);
    }

    @Test
    public void test9() {
        RectangleSquare squareRectangle = new RectangleSquare();
        int[] x = {0, 0, 5, 10, 0, 0, 0, 0, 0, 0};
        int[] h = {20, 10, 15, 5, 5, 20, 30, 5, 30, 15};
        int[] w = {10, 20, 10, 5, 20, 20, 5, 30, 15, 30};
        int result = squareRectangle.measure(x, h, w);
        assertEquals(700, result);
    }
}