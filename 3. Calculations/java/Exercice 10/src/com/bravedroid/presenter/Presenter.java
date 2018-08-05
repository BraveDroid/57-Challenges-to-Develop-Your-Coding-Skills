package com.bravedroid.presenter;

import com.bravedroid.businesslogic.SelfCheckoutCalculator;
import com.bravedroid.businesslogic.SelfCheckoutVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Presenter {
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";
    private static final String REQUEST_MESSAGE_PRICE_ITEM1 = "Enter the price of item 1:";
    private static final String REQUEST_MESSAGE_PRICE_ITEM2 = "Enter the price of item 2:";
    private static final String REQUEST_MESSAGE_PRICE_ITEM3 = "Enter the price of item 3:";
    private static final String REQUEST_MESSAGE_QUANTITY_ITEM1 = "Enter the quantity of item 1:";
    private static final String REQUEST_MESSAGE_QUANTITY_ITEM2 = "Enter the quantity of item 2:";
    private static final String REQUEST_MESSAGE_QUANTITY_ITEM3 = "Enter the quantity of item 3:";


    private InputDTO inputDTO = new InputDTO();
    private SelfCheckoutCalculator selfCheckoutCalculator;
    private BufferedReader input;
    private boolean mustExit;


    public Presenter(SelfCheckoutCalculator selfCheckoutCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.selfCheckoutCalculator = selfCheckoutCalculator;
    }

    private void verifyInput(double inputInDouble) throws IOException {
            if (inputInDouble < 1)
                throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }


    public void readPriceOfItem1() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_PRICE_ITEM1);
        String priceOfItem1InString = input.readLine();
        if (priceOfItem1InString.equals("exit")) {
            mustExit = true;
            return;
        }
        double inputInDouble = 0;
        try {
            inputInDouble = Double.parseDouble(priceOfItem1InString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            readPriceOfItem1();
        }

        try {
            verifyInput(inputInDouble);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readPriceOfItem1();
            return;
        }
        inputDTO.setPriceOfItem1(inputInDouble);
    }

    public void readQuantityOfItem1() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_QUANTITY_ITEM1);
        String quantityOfItem1InString = input.readLine();
        if (quantityOfItem1InString.equals("exit")) {
            mustExit = true;
            return;
        }
        double inputInDouble = 0;

        try {
            inputInDouble = Double.parseDouble(quantityOfItem1InString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            readQuantityOfItem1();
        }

        try {
            verifyInput(inputInDouble);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readQuantityOfItem1();
            return;
        }
        inputDTO.setQuantityOfItem1(inputInDouble);
    }

    public void readPriceOfItem2() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_PRICE_ITEM2);
        String priceOfItem2InString = input.readLine();
        if (priceOfItem2InString.equals("exit")) {
            mustExit = true;
            return;
        }
        double inputInDouble = 0;

        try {
            inputInDouble = Double.parseDouble(priceOfItem2InString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            readPriceOfItem2();
        }

        try {
            verifyInput(inputInDouble);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readPriceOfItem2();
            return;
        }
        inputDTO.setPriceOfItem2(inputInDouble);
    }

    public void readQuantityOfItem2() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_QUANTITY_ITEM2);
        String quantityOfItem2InString = input.readLine();
        if (quantityOfItem2InString.equals("exit")) {
            mustExit = true;
            return;
        }
        double inputInDouble = 0;

        try {
            inputInDouble = Double.parseDouble(quantityOfItem2InString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            readQuantityOfItem2();
        }

        try {
            verifyInput(inputInDouble);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readQuantityOfItem2();
            return;
        }
        inputDTO.setQuantityOfItem2(inputInDouble);
    }

    public void readPriceOfItem3() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_PRICE_ITEM3);
        String priceOfItem3InString = input.readLine();
        if (priceOfItem3InString.equals("exit")) {
            mustExit = true;
            return;
        }
        double inputInDouble = 0;

        try {
            inputInDouble = Double.parseDouble(priceOfItem3InString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            readPriceOfItem3();
        }

        try {
            verifyInput(inputInDouble);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readPriceOfItem3();
            return;
        }
        inputDTO.setPriceOfItem3(inputInDouble);
    }

    public void readQuantityOfItem3() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_QUANTITY_ITEM3);
        String quantityOfItem3InString = input.readLine();
        if (quantityOfItem3InString.equals("exit")) {
            mustExit = true;
            return;
        }
        double inputInDouble = 0;

        try {
            inputInDouble = Double.parseDouble(quantityOfItem3InString);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            readQuantityOfItem3();
        }

        try {
            verifyInput(inputInDouble);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readQuantityOfItem3();
            return;
        }
        inputDTO.setQuantityOfItem3(inputInDouble);
    }

    public void printSelfCheckout() {
        if (mustExit) return;

        SelfCheckoutVM vm = selfCheckoutCalculator.calculateSelfCheckout(inputDTO);

        double subtotal = vm.getSubtotal();
        double tax = vm.getTax();
        double total = vm.getTotal();

        System.out.println("Subtotal " + subtotal + "\n"
                + " Tax " + tax + "\n"
                + " Total " + total);
    }
}
