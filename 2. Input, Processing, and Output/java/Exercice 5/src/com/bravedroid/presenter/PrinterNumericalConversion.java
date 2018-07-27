package com.bravedroid.presenter;

import com.bravedroid.application.ConversionAdder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrinterNumericalConversion {
    private ConversionAdder conversionAdder;

    public PrinterNumericalConversion(ConversionAdder conversionAdder) {
        this.conversionAdder = conversionAdder;
    }

    public void printNumericalConversions() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the first number?");
        String firstNumAsString = input.readLine();
        System.out.println("What is the second number?");
        String secondNumAsString = input.readLine();
        String conversion;
        try {
            conversion = conversionAdder.addConversion(
                    Integer.parseInt(firstNumAsString),
                    Integer.parseInt(secondNumAsString)
            );
        } catch (NumberFormatException ex) {
            System.out.println(" the value entered is not numeric.");
            return;
        }
       // if (null != conversion)
            System.out.println(conversion);
    }
}
