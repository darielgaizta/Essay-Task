package com.darielgaizta.essaytask;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CalculatorTestCase {
    @Test
    public void zeroes() {
        /* Test: 0/0 should return NaN */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(0, 0, 0, 0), Double.NaN);
    }

    @Test
    public void allPositives() {
        /* Test: Division between positive numbers (+/+) should return a positive (+) number */
        Calculator calculator = new Calculator();

        double a = 1;
        double b = 2;
        double c = 3;
        double d = 4;

        double expected = 0.42857;
        double actual = calculator.count(a, b, c, d);
        Assert.assertEquals(actual, expected, 0.00001);
    }

    @Test
    public void allNegatives() {
        /* Test: Division between negative numbers (-/-) should return a positive (+) number */
        Calculator calculator = new Calculator();

        double a = -1;
        double b = -2;
        double c = -3;
        double d = -4;

        double expected = 0.42857;
        double actual = calculator.count(a, b, c, d);
        Assert.assertEquals(actual, expected, 0.00001);
    }

    @Test
    public void largeNumbers() {
        /* Test: Division between large numbers (MAX_VALUE & POSITIVE_INFINITY) should return NaN */
        Calculator calculator = new Calculator();
        Assert.assertEquals(
                calculator.count(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE),
                Double.NaN
        );
        Assert.assertEquals(
                calculator.count(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
                Double.NaN
        );
    }

    @Test
    public void smallNumbers() {
        /* Test: Division between NEGATIVE_INFINITY-s should return NaN and MIN_VALUE should return 1 */
        Calculator calculator =  new Calculator();
        Assert.assertEquals(
                calculator.count(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE),
                1
        );
        Assert.assertEquals(
                calculator.count(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
                Double.NaN
        );
    }

    @Test
    public void mixedRandomNumbers() {
        /* Test: Division between positive and negative (+/- or -/+) should return a negative number */
        Random random = new Random();
        Calculator calculator = new Calculator();

        double posValues = random.nextDouble();
        double negValues = random.nextDouble() * -1;
        double result1 = calculator.count(posValues, posValues, negValues, negValues);
        double result2 = calculator.count(negValues, negValues, posValues, posValues);

        Assert.assertTrue(result1 < 0, "Result 1 is negative.");
        Assert.assertTrue(result2 < 0, "Result 2 is negative.");
    }

    @Test
    public void anyWithZeroDivision() {
        /* Test: Any number divided by zero should return Infinite */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(1, 1, 0, 0), Double.POSITIVE_INFINITY);
        Assert.assertEquals(calculator.count(-1, -1, 0, 0), Double.NEGATIVE_INFINITY);
    }

    @Test
    public void largeNumberAsResult() {
        /* Test: Function should be able to return a large number */
        Calculator calculator = new Calculator();
        Assert.assertNotEquals(calculator.count(Double.MAX_VALUE, 1, 1, 0), Double.POSITIVE_INFINITY);
    }

    @Test
    public void smallNumberAsResult() {
        /* Test: Function should be able to return a small number */
        Calculator calculator = new Calculator();
        Assert.assertNotEquals(calculator.count(Double.MAX_VALUE, 1, -1, 0), Double.NEGATIVE_INFINITY);
    }

    @Test
    public void randomNumbers() {
        Calculator calculator = new Calculator();

        double a = Math.random();
        double b = Math.random();
        double c = Math.random();
        double d = Math.random();

        double result = calculator.count(a, b, c, d);

        if (c + d == 0) {
            if (a + b == 0) {
                /* Test: 0/0 should return NaN */
                Assert.assertEquals(result, Double.NaN);
            } else {
                /* Test: Any random number divided by zero should return infinite */
                Assert.assertEquals(result, Double.POSITIVE_INFINITY);
            }
        } else {
            /* Test: Function should return any positive number */
            Assert.assertTrue(result > 0);
        }
    }

    @Test
    public void precisionCheck() {
        /* Test: Function should return a precise number */
        Calculator calculator = new Calculator();

        double a = 1.00004;
        double b = 1.00012;
        double c = 2.00003;
        double d = 1.22212;

        double expected = 0.62075322;
        double actual = calculator.count(a, b, c, d);
        Assert.assertEquals(actual, expected, 0.00000001);
    }

    @Test
    public void commutativeCheck() {
        /* Test: Function should apply a commutative law */
        Calculator calculator = new Calculator();

        double a = 1;
        double b = 2;
        double c = 3;
        double d = 4;

        double expected = 0.42857;
        double actual = calculator.count(b, a, d, c);
        Assert.assertEquals(actual, expected, 0.00001);
    }
}