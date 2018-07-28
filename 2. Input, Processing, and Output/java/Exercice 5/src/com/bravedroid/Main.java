package com.bravedroid;

import com.bravedroid.application.ConversionAdder;
import com.bravedroid.presenter.PrinterNumericalConversion;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConversionAdder conversionAdder = new ConversionAdder();
        PrinterNumericalConversion printerNumericalConversion = new PrinterNumericalConversion(conversionAdder);
        printerNumericalConversion.provideInput();
        printerNumericalConversion.printNumericalConversions();
    }
}
