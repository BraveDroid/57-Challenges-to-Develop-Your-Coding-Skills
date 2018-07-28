package com.bravedroid;

import com.bravedroid.application.RetirementCalculator;
import com.bravedroid.presenter.RetirementCalculatorPrinter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        RetirementCalculator retirementCalculator = new RetirementCalculator();
        RetirementCalculatorPrinter printerRetirementCalculator = new RetirementCalculatorPrinter(retirementCalculator);
        printerRetirementCalculator.provideInputs();
        printerRetirementCalculator.printRetirementCalculationInfos();
    }
}
