package com.darielgaizta.essaytask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        try {
            System.out.print("Input a: ");
            double a = scanner.nextDouble();
            System.out.print("Input b: ");
            double b = scanner.nextDouble();
            System.out.print("Input c: ");
            double c = scanner.nextDouble();
            System.out.print("Input d: ");
            double d = scanner.nextDouble();

            double result = calculator.count(a, b, c, d);

            System.out.printf("Calculation for (a + b)/(c + d) is %f\n", result);
        } catch (InputMismatchException e) {
            System.out.printf("ERROR Please input a real number (%s)\n", e);
        } catch (Exception e) {
            System.out.printf("Unknown error occurred. (%s)\n", e);
        }

        scanner.close();
    }
}
