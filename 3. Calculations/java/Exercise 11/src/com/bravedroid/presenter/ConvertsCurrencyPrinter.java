package com.bravedroid.presenter;

import com.bravedroid.businesslogic.ConvertsCurrencyCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ConvertsCurrencyPrinter {
    private static final String REQUEST_MESSAGE_EUROS_EXCHANGE = "How many euros are you exchanging? ";
    private static final String REQUEST_MESSAGE_EXCHANGE_RATE = "What is the exchange rate? ";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";
    private double amountFrom;
    private double rateFrom;
    private ConvertsCurrencyCalculator convertsCurrencyCalculator;
    private BufferedReader input;
    private boolean mustExit;

    public ConvertsCurrencyPrinter(ConvertsCurrencyCalculator convertsCurrencyCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.convertsCurrencyCalculator = convertsCurrencyCalculator;
    }

    private void verifyInput(double inputInDouble) throws IOException {
        if (inputInDouble < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }

    public void readAmountFrom() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_EUROS_EXCHANGE);
        try {
            String amountFromInString = input.readLine();
            if (amountFromInString.equals("exit")) {
                mustExit = true;
                return;
            }
            amountFrom = Double.parseDouble(amountFromInString);
            validateNumIsGreaterThanZero(amountFrom);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readAmountFrom();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readAmountFrom();
        }
    }

    public void readRateFrom() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_EXCHANGE_RATE);
        try {
            String rateFromInString = input.readLine();
            if (rateFromInString.equals("exit")) {
                mustExit = true;
                return;
            }
            rateFrom = Double.parseDouble(rateFromInString);
            validateNumIsGreaterThanZero(amountFrom);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readRateFrom();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readRateFrom();
        }
    }

    public void printConvertsCurrency() {
        if (mustExit) return;
        double amountTo = convertsCurrencyCalculator.calculateConvertsCurrency(amountFrom, rateFrom);
        amountTo = Double.parseDouble(new DecimalFormat("##.##").format(amountTo));
        System.out.println((int)amountFrom + " euros at an exchange rate of " + rateFrom + " is " + "\n" +
                amountTo + " U.S.dollars.");
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
