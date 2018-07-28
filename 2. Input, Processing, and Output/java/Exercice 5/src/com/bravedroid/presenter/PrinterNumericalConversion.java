package com.bravedroid.presenter;

import com.bravedroid.application.ConversionAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterNumericalConversion {
    private ConversionAdder conversionAdder;
    private String conversion;
    private String firstNumAsString;
    private String secondNumAsString;

    public PrinterNumericalConversion(ConversionAdder conversionAdder) {
        this.conversionAdder = conversionAdder;
    }

    public void provideInput() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the first number?");
        firstNumAsString = input.readLine();
        System.out.println("What is the second number?");
        secondNumAsString = input.readLine();
    }

    public void printNumericalConversions() {
        try {
            conversion = conversionAdder.addConversion(
                    Integer.parseInt(firstNumAsString),
                    Integer.parseInt(secondNumAsString)
            );
        } catch (NumberFormatException ex) {
            System.out.println(" the value entered is not numeric.");
        }
        if (conversion != null) {
            System.out.println(conversion);
        }
    }
}
