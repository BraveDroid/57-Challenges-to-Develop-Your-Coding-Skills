package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumbersToNamesPrinter {
    private static final String REQUEST_MESSAGE_NUMBER_OF_MONTH = "Please enter the number of the month: ";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private int numberOfMonth;
    private boolean mustExit;

    private BufferedReader input;

    public NumbersToNamesPrinter() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readNumberOfTheMonth() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_NUMBER_OF_MONTH);
        try {
            String numberOfMonthInString = input.readLine();
            if (numberOfMonthInString.equalsIgnoreCase("exit")) {
                mustExit = true;
                return;
            }
            numberOfMonth = Integer.parseInt(numberOfMonthInString);
            validateNumIsGreaterThanZero(numberOfMonth);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumberOfTheMonth();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumberOfTheMonth();
        }
    }

    public void printNumbersToNames() {
        if (mustExit) return;
        switch (numberOfMonth) {
            case 1:
                System.out.println("The name of the month is January.");
                break;
            case 2:
                System.out.println("The name of the month is February.");
                break;
            case 3:
                System.out.println("The name of the month is March.");
                break;
            case 4:
                System.out.println("The name of the month is April.");
                break;
            case 5:
                System.out.println("The name of the month is Mai.");
                break;
            case 6:
                System.out.println("The name of the month is June.");
                break;
            case 7:
                System.out.println("The name of the month is July.");
                break;
            case 8:
                System.out.println("The name of the month is august.");
                break;
            case 9:
                System.out.println("The name of the month is September.");
                break;
            case 10:
                System.out.println("The name of the month is October.");
                break;
            case 11:
                System.out.println("The name of the month is November.");
                break;
            case 12:
                System.out.println("The name of the month is December.");
                break;
        }
    }

    private void validateNumIsGreaterThanZero(double number) throws IOException {
        if (number < 1) {
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
        }
        if (number > 12) {
            throw new IllegalArgumentException(" Input must be maximum equal to 12 or less ");
        }
    }
}
