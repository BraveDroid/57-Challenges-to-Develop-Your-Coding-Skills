package com.bravedroid;

import com.bravedroid.businesslogic.ConvertsCurrencyCalculator;
import com.bravedroid.presenter.ConvertsCurrencyPrinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConvertsCurrencyCalculator convertsCurrencyCalculator = new ConvertsCurrencyCalculator();
        ConvertsCurrencyPrinter convertsCurrencyPrinter = new ConvertsCurrencyPrinter(convertsCurrencyCalculator);
        convertsCurrencyPrinter.readAmountFrom();
        convertsCurrencyPrinter.readRateFrom();
        convertsCurrencyPrinter.printConvertsCurrency();
    }
}
