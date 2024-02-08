package com.darielgaizta.essaytask;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CalculatorTestCase {
    @Test(description = "0/0 should return NaN.")
    public void zeroes() {
        /* Test: 0/0 should return NaN */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(0, 0, 0, 0), Double.NaN);
    }

    @Test(description = "Division between positive numbers (+/+) should return a positive (+) number")
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

    @Test(description = "Division between negative numbers (-/-) should return a positive (+) number")
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

    @Test(description = "Division between large positive numbers (MAX_VALUE) should return 1")
    public void largePositiveNumbers() {
        /* Test: Division between large positive numbers (MAX_VALUE) should return 1
        * This method will test if the function can handle a large positive number like MAX_VALUE. */
        Calculator calculator = new Calculator();
        Assert.assertEquals(
                calculator.count(Double.MAX_VALUE, 0, Double.MAX_VALUE, 0),
                1
        );
    }

    @Test(description = "Division between POSITIVE_INFINITY-s should return NaN")
    public void positiveInfinityNumbers() {
        /* Test: Division between POSITIVE_INFINITY-s should return NaN */
        Calculator calculator = new Calculator();
        Assert.assertEquals(
                calculator.count(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY),
                Double.NaN
        );
    }

    @Test(description = "Division between small positive numbers (MIN_VALUE) should return 1")
    public void smallPositiveNumbers() {
        /* Test: Division between small positive numbers (MIN_VALUE) should return 1
        * This method will test if the function can handle a small positive number like MIN_VALUE. */
        Calculator calculator =  new Calculator();
        Assert.assertEquals(
                calculator.count(Double.MIN_VALUE, 0, Double.MIN_VALUE, 0),
                1
        );
    }

    @Test(description = "Division between large negative numbers (-MAX_VALUE) should return 1")
    public void largeNegativeNumbers() {
        /* Test: Division between large negative numbers (-MAX_VALUE) should return 1 */
        Calculator calculator = new Calculator();
        Assert.assertEquals(
                calculator.count(-Double.MAX_VALUE, 0, -Double.MAX_VALUE, 0),
                1
        );
    }

    @Test(description = "Division between NEGATIVE_INFINITY-s should return NaN")
    public void negativeInfinityNumbers() {
        /* Test: Division between NEGATIVE_INFINITY-s should return NaN */
        Calculator calculator = new Calculator();
        Assert.assertEquals(
                calculator.count(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY),
                Double.NaN
        );
    }

    @Test(description = "Positive numbers divided by negative numbers should return a negative number")
    public void positivesDividedByNegatives() {
        /* Test: Positive numbers divided by negative numbers (+/-) should return a negative number (-) */
        Random random = new Random();
        Calculator calculator = new Calculator();

        double posValues = random.nextDouble();
        double negValues = random.nextDouble() * -1;
        double result = calculator.count(posValues, posValues, negValues, negValues);
        Assert.assertTrue(result < 0);
    }

    @Test(description = "Negative numbers divided by positive numbers should return a negative number")
    public void negativesDividedByPositives() {
        /* Test: Negative numbers divided by positive numbers (-/+) should return a negative number (-) */
        Random random = new Random();
        Calculator calculator = new Calculator();

        double posValues = random.nextDouble();
        double negValues = random.nextDouble() * -1;
        double result = calculator.count(negValues, negValues, posValues, posValues);
        Assert.assertTrue(result < 0);
    }

    @Test(description = "Positive numbers divided by zero should return Infinite")
    public void positivesWithZeroDivision() {
        /* Test: Positive numbers divided by zero should return Infinite */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(1, 1, 0, 0), Double.POSITIVE_INFINITY);
    }

    @Test(description = "Negative numbers divided by zero should return negative Infinite")
    public void negativeWithZeroDivision() {
        /* Test: Negative numbers divided by zero should return negative Infinite */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(-1, -1, 0, 0), Double.NEGATIVE_INFINITY);
    }

    @Test(description = "Function should be able to return a large positive number (MAX_VALUE)")
    public void largePositiveNumberAsResult() {
        /* Test: Function should be able to return a large positive number (MAX_VALUE) */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(Double.MAX_VALUE, 0, 1, 0), Double.MAX_VALUE);
    }

    @Test(description = "Function should be able to return a small positive number (MIN_VALUE)")
    public void smallPositiveNumberAsResult() {
        /* Test: Function should be able to return a small positive number (MIN_VALUE) */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(Double.MIN_VALUE, 0, 1, 0), Double.MIN_VALUE);
    }

    @Test(description = "Function should be able to return a large negative number (-MAX_VALUE)")
    public void largeNegativeNumberAsResult() {
        /* Test: Function should be able to return a large negative number (-MAX_VALUE) */
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.count(Double.MAX_VALUE, 0, -1, 0), -Double.MAX_VALUE);
    }

    @Test(description = "Function should return a precise number")
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

    @Test(description = "Function should apply a commutative law")
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