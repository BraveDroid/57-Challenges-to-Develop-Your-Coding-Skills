package com.bravedroid.presenter;

import com.bravedroid.businessLogic.TaxCalculator;
import com.bravedroid.businessLogic.TaxCalculatorVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxPrinter {
    private static final String REQUEST_MESSAGE_ORDER_AMOUNT = "What is the order amount? ";
    private static final String REQUEST_MESSAGE_STATE = "What is the state ? ";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";


    private TaxCalculator taxCalculator;
    private BufferedReader input;
    private boolean mustExit;
    private String state;
    private double orderAmount;

    public TaxPrinter(TaxCalculator taxCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.taxCalculator = taxCalculator;
    }

    public void readOrderAmount() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_ORDER_AMOUNT);
        try {
            String orderAmountString = input.readLine();
            if (orderAmountString.equals("exit")) {
                mustExit = true;
                return;
            }
            orderAmount = Double.parseDouble(orderAmountString);
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
        if (state.equals("exit"))
            mustExit = true;
    }

    public void printTax() {
        if (mustExit) return;
        TaxCalculatorVM vm = taxCalculator.calculateTax(orderAmount);
        if (state.equals("WI")) {
            System.out.println("The Subtotal is $" + vm.getSubtotal() + "." + "\n" +
                    "The tax is $" + vm.getTax() + "." + "\n" +
                    "The total is $" + vm.getTotal());
            return;
        }
        System.out.println("The total is $" + vm.getSubtotal());
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
