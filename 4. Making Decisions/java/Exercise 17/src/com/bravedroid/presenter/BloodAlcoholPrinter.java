package com.bravedroid.presenter;

import com.bravedroid.businesslogic.BloodAlcoholCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class BloodAlcoholPrinter {
    private static final String REQUEST_MESSAGE_WEIGHT = "Enter your weight?";
    private static final String REQUEST_MESSAGE_GENDER = "Enter your gender?";
    private static final String REQUEST_MESSAGE_AMOUNT_OF_ALCOHOL_CONSUMED = "Enter the amount of alcohol consumed?";
    private static final String REQUEST_MESSAGE_AMOUNT_OF_TIME_SINCE_LAST_DRINK = "Enter the amount of time since last drink?";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private InputFormUserDTO inputFormUserDTO;
    private BloodAlcoholCalculator bloodAlcoholCalculator;
    private BufferedReader input;
    private boolean mustExit;

    public BloodAlcoholPrinter(BloodAlcoholCalculator bloodAlcoholCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        inputFormUserDTO = new InputFormUserDTO();
        this.bloodAlcoholCalculator = bloodAlcoholCalculator;
    }

    public void readWeight() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_WEIGHT);
        try {
            String weighString = input.readLine();
            if (weighString.equals("exit")) {
                mustExit = true;
                return;
            }
            double weight = Double.parseDouble(weighString);
            inputFormUserDTO.setWeight(weight);
            validateNumIsGreaterThanZero(weight);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readWeight();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readWeight();
        }
    }

    public void readGender() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_GENDER);
        String gender = input.readLine();
        if (gender.equals("man") || gender.equals("woman")) {
            inputFormUserDTO.setGender(gender);
        } else {
            System.out.println("Enter a valid gender(man/woman) ");
            readGender();
        }
        inputFormUserDTO.setGender(gender);
        if (gender.equals("exit")) {
            mustExit = true;
        }
    }

    public void readAmountOfAlcoholConsumed() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_AMOUNT_OF_ALCOHOL_CONSUMED);
        try {
            String amountOfAlcoholConsumedString = input.readLine();
            if (amountOfAlcoholConsumedString.equals("exit")) {
                mustExit = true;
                return;
            }
            double amountOfAlcoholConsumed = Double.parseDouble(amountOfAlcoholConsumedString);
            inputFormUserDTO.setAmountOfAlcoholConsumed(amountOfAlcoholConsumed);
            validateNumIsGreaterThanZero(amountOfAlcoholConsumed);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readAmountOfAlcoholConsumed();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readAmountOfAlcoholConsumed();
        }
    }

    public void readNumberOfHoursSinceLastDrink() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_AMOUNT_OF_TIME_SINCE_LAST_DRINK);
        try {
            String amountOfTimeSinceLastDrinkString = input.readLine();
            if (amountOfTimeSinceLastDrinkString.equals("exit")) {
                mustExit = true;
                return;
            }
            double amountOfTimeSinceLastDrink = Double.parseDouble(amountOfTimeSinceLastDrinkString);
            inputFormUserDTO.setAmountOfTimeSinceLastDrink(amountOfTimeSinceLastDrink);
            validateNumIsGreaterThanZero(amountOfTimeSinceLastDrink);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumberOfHoursSinceLastDrink();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumberOfHoursSinceLastDrink();
        }
    }

    public void printBloodAlcoholCalculator() {
        if (mustExit) return;
        double BAC = bloodAlcoholCalculator.calculateBloodAlcohol(inputFormUserDTO);
        BAC = Double.parseDouble(new DecimalFormat("##.##").format(BAC));
        final double comparatorBAC = 0.08;
        boolean conditionBAC = BAC >= comparatorBAC;
        String outputInLegalCaseToDrive = "Your BAC is " + BAC + "\n" +
                "It is legal for you to drive.";
        String outputInIllegalCaseToDrive = "Your BAC is " + BAC + "\n" +
                "It is not legal for you to drive.";
        String output = (conditionBAC) ? outputInIllegalCaseToDrive : outputInLegalCaseToDrive;
        System.out.println(output);
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}

