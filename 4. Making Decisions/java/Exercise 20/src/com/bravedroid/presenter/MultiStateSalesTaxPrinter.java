package com.bravedroid.presenter;

import com.bravedroid.businesslogic.MultiStateSalesTaxCalculator;
import com.bravedroid.businesslogic.MultiStateSalesTaxCalculatorVM;
import com.bravedroid.businesslogic.util.NumberFormatHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class MultiStateSalesTaxPrinter {
    private static final String REQUEST_MESSAGE_ORDER_AMOUNT = "What is the order amount?";
    private static final String REQUEST_MESSAGE_STATE = "What state do you live in?";
    private static final String REQUEST_MESSAGE_COUNTRY = "What Country do you live in?";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private double orderAmount;
    private String state;
    private String country;
    private boolean mustExit;
    private BufferedReader input;
    private MultiStateSalesTaxCalculator multiStateSalesTaxCalculator;
    private NumberFormatHelper nHelper;

    public MultiStateSalesTaxPrinter(MultiStateSalesTaxCalculator multiStateSalesTaxCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.multiStateSalesTaxCalculator = multiStateSalesTaxCalculator;
        nHelper = new NumberFormatHelper();
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
        } else {
            return;
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
        switch (state) {
            case "WISCONSIN":
                switch (country) {
                    case "EAU CLAIRE":
                        double totalInEauClaire = vm.getTaxInEauClaire() + orderAmount;
                        totalInEauClaire = nHelper.formatNumberToTheNearestCent(totalInEauClaire);
                        totalInEauClaire = Double.parseDouble(new DecimalFormat("##.###").format(totalInEauClaire));
                        System.out.println("The tax is $" + vm.getTaxInEauClaire() + "." + "\n" + "The total is $" + totalInEauClaire + ".");
                        break;
                    case "DUNN":
                        double totalInDunn = vm.getTaxInDunn() + orderAmount;
                        totalInDunn = nHelper.formatNumberToTheNearestCent(totalInDunn);
                        totalInDunn = Double.parseDouble(new DecimalFormat("##.###").format(totalInDunn));
                        System.out.println("The tax is $" + vm.getTaxInDunn() + "." + "\n" + "The total is $" + totalInDunn + ".");
                        break;
                    default:
                        double totalInWisconsin = vm.getTaxInWisconsin() + orderAmount;
                        totalInWisconsin = Double.parseDouble(new DecimalFormat("##.###").format(totalInWisconsin));
                        totalInWisconsin = nHelper.formatNumberToTheNearestCent(totalInWisconsin);
                        System.out.println("The tax is $" + vm.getTaxInWisconsin() + "\n" + "The total is $" + totalInWisconsin + ".");
                        break;
                }
                break;
            case "ILLINOIS":
                double totalInIllinois = vm.getTaxInIllinois() + orderAmount;
                totalInIllinois = nHelper.formatNumberToTheNearestCent(totalInIllinois);
                totalInIllinois = Double.parseDouble(new DecimalFormat("##.###").format(totalInIllinois));
                System.out.println("The tax is $" + vm.getTaxInIllinois() + "." + "\n" + "The total is $" + totalInIllinois + ".");
                break;
            default:
                System.out.println("The total is $" + vm.getTaxInOtherState());
                break;
        }
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
