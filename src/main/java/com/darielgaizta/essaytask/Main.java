package com.darielgaizta.essaytask;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        App app = new App(scanner);

        app.appCalculator();

        scanner.close();
    }
}
