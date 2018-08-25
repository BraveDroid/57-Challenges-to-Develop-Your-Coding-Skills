package com.bravedroid;

import com.bravedroid.presenter.NumbersToNamesPrinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        NumbersToNamesPrinter numbersToNamesPrinter = new NumbersToNamesPrinter();
        numbersToNamesPrinter.readNumberOfTheMonth();
        numbersToNamesPrinter.printNumbersToNames();
    }
}
