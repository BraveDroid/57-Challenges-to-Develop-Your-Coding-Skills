package com.bravedroid;

import com.bravedroid.businesslogic.MultiStateSalesTaxCalculator;
import com.bravedroid.presenter.MultiStateSalesTaxPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        MultiStateSalesTaxCalculator multiStateSalesTaxCalculator = new MultiStateSalesTaxCalculator();
        MultiStateSalesTaxPrinter multiStateSalesTaxPrinter = new MultiStateSalesTaxPrinter(multiStateSalesTaxCalculator);
        multiStateSalesTaxPrinter.readOrderAmount();
        multiStateSalesTaxPrinter.readState();
        multiStateSalesTaxPrinter.readCountry();
        multiStateSalesTaxPrinter.printMultiStateSalesTax();
    }
}
