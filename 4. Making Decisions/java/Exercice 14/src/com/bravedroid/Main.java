package com.bravedroid;

import com.bravedroid.businessLogic.TaxCalculator;
import com.bravedroid.presenter.TaxPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TaxCalculator taxCalculator = new TaxCalculator();
        TaxPrinter taxPrinter = new TaxPrinter(taxCalculator);
        taxPrinter.readOrderAmount();
        taxPrinter.readState();
        taxPrinter.printTax();
    }
}
