package com.bravedroid.presenter;

import com.bravedroid.businesslogic.AmountInvestmentCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleInterestPrinter {
    private static final String REQUEST_MESSAGE_PRINCIPAL_AMOUNT = "Enter the principal: ";
    private static final String REQUEST_MESSAGE_RATE_OF_INTEREST = "Enter the rate of interest: ";
    private static final String REQUEST_MESSAGE_NUMBER_OF_YEARS = "Enter the number of years: ";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private BufferedReader input;
    private AmountInvestmentCalculator amountInvestmentCalculator;
    private double principalAmount;
    private double rateOfInterest;
    private int numberOfYears;
    private boolean mustExit;

    public SimpleInterestPrinter(AmountInvestmentCalculator amountInvestmentCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.amountInvestmentCalculator = amountInvestmentCalculator;
    }

    public void readPrincipalAmount() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_PRINCIPAL_AMOUNT);
        try {
            String principalAmountString = input.readLine();
            if (principalAmountString.equals("exit")) {
                mustExit = true;
                return;
            }
            principalAmount = Double.parseDouble(principalAmountString);
            validateNumIsGreaterThanZero(principalAmount);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readPrincipalAmount();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readPrincipalAmount();
        }
    }

    public void readRateOfInterest() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_RATE_OF_INTEREST);
        try {
            String rateOfInterestString = input.readLine();
            if (rateOfInterestString.equals("exit")) {
                mustExit = true;
                return;
            }
            rateOfInterest = Double.parseDouble(rateOfInterestString);
            validateNumIsGreaterThanZero(rateOfInterest);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readRateOfInterest();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readRateOfInterest();
        }
    }

    public void readNumberOfYears() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_NUMBER_OF_YEARS);
        try {
            String numberOfYearsString = input.readLine();
            if (numberOfYearsString.equals("exit")) {
                mustExit = true;
                return;
            }
            numberOfYears = Integer.parseInt(numberOfYearsString);
            validateNumIsGreaterThanZero(numberOfYears);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readNumberOfYears();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readNumberOfYears();
        }
    }

    public void printSimpleInterest() {
        if (mustExit) return;
        double amountInvestment = amountInvestmentCalculator.calculateAmountInvestment(principalAmount, rateOfInterest, numberOfYears);
        System.out.println("After " + numberOfYears + " years at " + rateOfInterest + "%, the investment will be worth $" + (int) amountInvestment);
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
