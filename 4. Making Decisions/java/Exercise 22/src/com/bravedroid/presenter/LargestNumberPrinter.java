package com.bravedroid.presenter;

import com.bravedroid.business.LargestNumberFinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestNumberPrinter {
    private static final String REQUEST_MESSAGE_FIRST_NUMBER = "Enter the first number: ";
    private static final String REQUEST_MESSAGE_SECOND_NUMBER = "Enter the second number: ";
    private static final String REQUEST_MESSAGE_THIRD_NUMBER = "Enter the third number: ";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private double number1;
    private double number2;
    private double number3;
    private LargestNumberFinder largestNumberFinder;
    private BufferedReader input;
    private boolean mustExit;


    public LargestNumberPrinter(LargestNumberFinder largestNumberFinder) {
        this.largestNumberFinder = largestNumberFinder;
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readNumber1() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_FIRST_NUMBER);
        try {
            String firstNumber = input.readLine();
            if (exitInput(firstNumber)) {
                return;
            }
            number1 = Double.parseDouble(firstNumber);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumber1();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumber1();
        }
    }

    public void readNumber2() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_SECOND_NUMBER);
        try {
            String secondNumber = input.readLine();
            if (exitInput(secondNumber)) {
                return;
            }
            number2 = Double.parseDouble(secondNumber);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumber2();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumber2();
        }
    }

    public void readNumber3() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_THIRD_NUMBER);
        try {
            String thirdNumber = input.readLine();
            if (exitInput(thirdNumber)) {
                return;
            }
            number3 = Double.parseDouble(thirdNumber);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumber3();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumber3();
        }
    }

    public void printLargestNumber() {
        if (mustExit) return;
        double largestNumber = largestNumberFinder.findLargestNumber(number1, number2, number3);
        System.out.println("The largest number is " + largestNumber);
    }

    private boolean exitInput(String inputFromUse) {
        if (inputFromUse.equalsIgnoreCase("exit")) {
            mustExit = true;
        }
        return mustExit;
    }
}
