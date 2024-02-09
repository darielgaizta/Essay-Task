package com.darielgaizta.essaytask;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class AppTestCase {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeMethod
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
        outContent.reset();
    }

    @Test(description = "Test application with valid input (real numbers)")
    public void testAppCalculator() {
        String input = "1\n2\n3\n4\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App app = new App(new Scanner(System.in));
        app.appCalculator();

        String expectedOutput = "Input a: Input b: Input c: Input d: Calculation for (a + b)/(c + d) is 0.428571\n";
        Assert.assertEquals(outContent.toString(), expectedOutput);
    }

    @Test(description = "Test application with invalid input (strings)")
    public void testAppCalculatorWithInvalidInput() {
        String input = "a\nb\nc\nd\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        App app = new App(new Scanner(System.in));
        app.appCalculator();

        String expectedOutput = "Input a: ERROR Please input a real number (java.util.InputMismatchException)\n";
        Assert.assertEquals(outContent.toString(), expectedOutput);
    }
}
