package com.bravedroid;

import com.bravedroid.businesslogic.BMICalculator;
import com.bravedroid.presenter.BMIPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BMICalculator bmiCalculator = new BMICalculator();
        BMIPrinter bmiPrinter = new BMIPrinter(bmiCalculator);
        bmiPrinter.readHeightInInches();
        bmiPrinter.readWeightInPounds();
        bmiPrinter.printBMI();
    }
}
