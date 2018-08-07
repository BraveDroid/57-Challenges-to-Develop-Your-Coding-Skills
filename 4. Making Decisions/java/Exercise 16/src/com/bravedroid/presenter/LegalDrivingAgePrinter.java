package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LegalDrivingAgePrinter {
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private int age;
    private BufferedReader input;
    private boolean mustExit;

    public LegalDrivingAgePrinter() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void readAge() throws IOException {
        System.out.println("What is your age?");
        try {
            String ageInString = input.readLine();
            if (ageInString.equals("exit")) {
                mustExit = true;
                return;
            }
            age = Integer.parseInt(ageInString);
            validateNumIsGreaterThanZero(age);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readAge();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readAge();
        }
    }

    public void printLegalDrivingAge() {
        if (mustExit) return;
        final String messageToPrint;
        boolean isLegalDriveAge = age > 1;
        final String outputLegalDriveAge = "You are old enough to legally drive.";
        final String outputIllegalDriveAge = "You are not old enough to legally drive.";
        messageToPrint = (isLegalDriveAge) ? outputLegalDriveAge : outputIllegalDriveAge;
        System.out.println(messageToPrint);
    }

    private void validateNumIsGreaterThanZero(int number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
