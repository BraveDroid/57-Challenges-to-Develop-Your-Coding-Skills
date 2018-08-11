package com.bravedroid.presenter;

import com.bravedroid.businesslogic.BMICalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class BMIPrinter {
    private static final String REQUEST_MESSAGE_WEIGHT_IN_POUNDS = "Enter your weight in pounds?";
    private static final String REQUEST_MESSAGE_HEIGHT_IN_INCHES = "Enter your height in inches?";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private BufferedReader input;
    private BMICalculator bmiCalculator;
    private boolean mustExit;
    private double heightInInches;
    private double weightInPounds;

    public BMIPrinter(BMICalculator bmiCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.bmiCalculator = bmiCalculator;
    }

    public void readHeightInInches() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_HEIGHT_IN_INCHES);
        try {
            String heightInString = input.readLine();
            if (heightInString.equals("exit")) {
                mustExit = true;
                return;
            }
            heightInInches = Double.parseDouble(heightInString);
            validateNumIsGreaterThanZero(heightInInches);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readHeightInInches();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readHeightInInches();
        }
    }

    public void readWeightInPounds() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_WEIGHT_IN_POUNDS);
        try {
            String WeightInString = input.readLine();
            if (WeightInString.equals("exit")) {
                mustExit = true;
                return;
            }
            weightInPounds = Double.parseDouble(WeightInString);
            validateNumIsGreaterThanZero(weightInPounds);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readWeightInPounds();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readWeightInPounds();
        }
    }

    public void printBMI() {
        if (mustExit) return;
        double bmi = bmiCalculator.calculateBMI(weightInPounds, heightInInches);
        boolean condition = 25 > bmi && bmi > 18.5;
        bmi = Double.parseDouble(new DecimalFormat("##.##").format(bmi));
        String outputInNormalWeight = "Your bmi is " + bmi + "\n"
                + "You are within the ideal weight range.";
        String outputInOverWeight = "Your bmi is " + bmi + "." + "\n"
                + "You are overweight. You should see your doctor.";
        String output = (condition) ? outputInNormalWeight : outputInOverWeight;
        System.out.println(output);
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
