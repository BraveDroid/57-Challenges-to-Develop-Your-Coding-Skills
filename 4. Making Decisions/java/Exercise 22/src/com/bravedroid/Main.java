package com.bravedroid;

import com.bravedroid.business.LargestNumberFinder;
import com.bravedroid.presenter.LargestNumberPrinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LargestNumberFinder largestNumberFinder = new LargestNumberFinder();
        LargestNumberPrinter largestNumberPrinter = new LargestNumberPrinter(largestNumberFinder);
        largestNumberPrinter.readNumber1();
        largestNumberPrinter.readNumber2();
        largestNumberPrinter.readNumber3();
        largestNumberPrinter.printLargestNumber();
    }
}
