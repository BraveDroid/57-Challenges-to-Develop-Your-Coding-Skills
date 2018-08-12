package com.bravedroid.presenter;

import com.bravedroid.businesslogic.MultiStateSalesTaxCalculator;
import com.bravedroid.businesslogic.MultiStateSalesTaxCalculatorVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class MultiStateSalesTaxPrinter {
    private static final String REQUEST_MESSAGE_ORDER_AMOUNT = "What is the order amount?";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";
    private static final String REQUEST_MESSAGE_STATE = "What state do you live in?";
    private static final String REQUEST_MESSAGE_COUNTRY = "What Country do you live in?";


    private double orderAmount;
    private String state;
    private String country;
    private boolean mustExit;
    private BufferedReader input;
    private MultiStateSalesTaxCalculator multiStateSalesTaxCalculator;

    public MultiStateSalesTaxPrinter(MultiStateSalesTaxCalculator multiStateSalesTaxCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.multiStateSalesTaxCalculator = multiStateSalesTaxCalculator;
    }

    public void readOrderAmount() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_ORDER_AMOUNT);
        try {
            String amountOrderInString = input.readLine();
            if (amountOrderInString.equalsIgnoreCase("exit")) {
                mustExit = true;
                return;
            }
            orderAmount = Double.parseDouble(amountOrderInString);
            validateNumIsGreaterThanZero(orderAmount);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readOrderAmount();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readOrderAmount();
        }
    }

    public void readState() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_STATE);
        state = input.readLine();
        if (state.equalsIgnoreCase("exit")) {
            mustExit = true;
            return;
        }
        boolean hasStateUppercase = !state.equals(state.toUpperCase());
        if (hasStateUppercase) {
            System.out.println("Must have an uppercase Character");
            readState();
        }
    }

    public void readCountry() throws IOException {
        if (mustExit) return;
        if (state.equals("WISCONSIN")) {
            System.out.println(REQUEST_MESSAGE_COUNTRY);
            country = input.readLine();
            if (country.equalsIgnoreCase("exit")) {
                mustExit = true;
                return;
            }
        }
        boolean hasCountryUpperCase = !country.equals(country.toUpperCase());
        if (hasCountryUpperCase) {
            System.out.println("Must have an uppercase Character");
            readCountry();
        }
    }

    public void printMultiStateSalesTax() {
        if (mustExit) return;
        MultiStateSalesTaxCalculatorVM vm = multiStateSalesTaxCalculator.calculateMultiStateSaleTax(orderAmount);
        if (state.equals("WISCONSIN") && country.equals("WISCONSIN")) {
            double totalInWisconsin = vm.getTaxInWisconsin() + orderAmount;
            totalInWisconsin = Double.parseDouble(new DecimalFormat("##.###").format(totalInWisconsin));
            System.out.println("The tax is $" + vm.getTaxInWisconsin() + "\n"
                    + "The total is $" + totalInWisconsin + ".");
        } else if (state.equals("WISCONSIN") && country.equals("EAU CLAIRE")) {
            double totalInEauClaire = vm.getTaxInEauClaire() + orderAmount;
            totalInEauClaire = Double.parseDouble(new DecimalFormat("##.###").format(totalInEauClaire));
            System.out.println("The tax is $" + vm.getTaxInEauClaire() + "." + "\n"
                    + "The total is $" + totalInEauClaire + ".");
        } else if (state.equals("WISCONSIN") && country.equals("DUNN")) {
            double totalInDunn = vm.getTaxInDunn() + orderAmount;
            totalInDunn = Double.parseDouble(new DecimalFormat("##.###").format(totalInDunn));
            System.out.println("The tax is $" + vm.getTaxInDunn() + "." + "\n"
                    + "The total is $" + totalInDunn + ".");
        } else if (state.equals("ILLINOIS")) {
            double totalInIllinois = vm.getTaxInIllinois() + orderAmount;
            totalInIllinois = Double.parseDouble(new DecimalFormat("##.###").format(totalInIllinois));
            System.out.println("The tax is $" + vm.getTaxInIllinois() + "." + "\n"
                    + "The total is $" + totalInIllinois + ".");
        } else {
            System.out.println("The total is $" + vm.getTaxInOtherState());
        }
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
