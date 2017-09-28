package Java_Practice.Practice_5_Parsing.ParseDigit;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Splayd on 14.01.2017.
 */
public class ParseTest {
    @Test
    public void checkNumbers() {
        double actual = new Parse().parseString("125");
        assertThat(actual, is(125.0));
    }

    @Test
    public void checkNegativeSignNumbers() {
        double actual = new Parse().parseString("-125");
        assertThat(actual, is(-125.0));
    }

    @Test
    public void checkPositiveSignNumbers() {
        double actual = new Parse().parseString("125.");
        assertThat(actual, is(125.0));
    }

    @Test
    public void checkDecimal() {
        double actual = new Parse().parseString("125.256");
        assertThat(actual, is(125.256));
    }

    @Test
    public void checkDecimalWithoutDigit() {
        double actual = new Parse().parseString(".256");
        assertThat(actual, is(0.256));
    }

    @Test
    public void checkOnlyDotInput() {
        double actual = new Parse().parseString(".");
        assertThat(actual, is(0.0));
    }

    @Test
    public void checkExpPart() {
        double actual = new Parse().parseString("2.e2");
        assertThat(actual, is(2.e2));
    }

    @Test
    public void checkComplexNumberInput() {
        double actual = new Parse().parseString("-.59e-2");
        assertThat(actual, is(-.59e-2));
    }

    @Test
    public void checkComplexNumberInput2() {
        double actual = new Parse().parseString("-.516e2");
        assertThat(actual, is(-.516e2));
    }

    @Test
    public void checkComplexNumberInput3() {
        double actual = new Parse().parseString(".0590e-4");
        assertThat(actual, is(.0590e-4));
    }

    @Test
    public void checkComplexNumberInput4() {
        double actual = new Parse().parseString(".0560e4");
        assertThat(actual, is(.0560e4));
    }

    @Test
    public void Couple() {
        double actual = new Parse().parseString("-2.305");
        assertThat(actual, is(-2.305));
    }

    @Test
    public void Couple1() {
        double actual = new Parse().parseString("-20.305");
        assertThat(actual, is(-20.305));
    }

    @Test
    public void Couple2() {
        double actual = new Parse().parseString("-02.305");
        assertThat(actual, is(-2.305));
    }

    @Test
    public void Couple3() {
        double actual = new Parse().parseString("-02.03050");
        assertThat(actual, is(-2.0305));
    }

    @Test
    public void Couple4() {
        double actual = new Parse().parseString("-0000020.03050");
        assertThat(actual, is(-20.0305));
    }

    @Test
    public void Couple5() {
        double actual = new Parse().parseString("+2.305");
        assertThat(actual, is(2.305));
    }

    @Test
    public void Couple6() {
        double actual = new Parse().parseString("+02.305");
        assertThat(actual, is(2.305));
    }

    @Test
    public void Couple7() {
        double actual = new Parse().parseString("+02.03050");
        assertThat(actual, is(2.0305));
    }

    @Test
    public void Couple8() {
        double actual = new Parse().parseString("+0200200.03050");
        assertThat(actual, is(200200.0305));
    }

    @Test
    public void Couple9() {
        double actual = new Parse().parseString("+020");
        assertThat(actual, is(20.0));
    }

    @Test
    public void Couple10() {
        double actual = new Parse().parseString("-020");
        assertThat(actual, is(-20.0));
    }

    @Test
    public void Couple11() {
        double actual = new Parse().parseString("-.03050");
        assertThat(actual, is(-0.0305));
    }

    @Test
    public void Couple12() {
        double actual = new Parse().parseString("-020.00300500");
        assertThat(actual, is(-20.003005));
    }

    @Test
    public void Couple13() {
        double actual = new Parse().parseString("+020.");
        assertThat(actual, is(20.0));
    }

    @Test
    public void Couple14() {
        double actual = new Parse().parseString("-.0");
        assertThat(actual, is(0.0));
    }

    @Test
    public void Couple15() {
        double actual = new Parse().parseString("-.");
        assertThat(actual, is(0.0));
    }

    @Test
    public void Couple16() {
        double actual = new Parse().parseString("-2.0e-10");
        assertThat(actual, is(-2.0e-10));
    }

    @Test
    public void Couple17() {
        double actual = new Parse().parseString("-2.e10");
        assertThat(actual, is(-2.0e10));
    }

    @Test
    public void Couple18() {
        double actual = new Parse().parseString(".e2");
        assertThat(actual, is(0.0));
    }

    @Test
    public void Couple19() {
        double actual = new Parse().parseString("");
        assertThat(actual, is(0.0));
    }

    @Test
    public void Couple20() {
        double actual = new Parse().parseString("abc");
        assertThat(actual, is(0.0));
    }

}