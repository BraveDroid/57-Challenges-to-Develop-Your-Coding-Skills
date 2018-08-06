package com.bravedroid;

import com.bravedroid.businesslogic.AmountInvestmentCalculator;
import com.bravedroid.presenter.SimpleInterestPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AmountInvestmentCalculator amountInvestmentCalculator = new AmountInvestmentCalculator();
        SimpleInterestPrinter simpleInterestPrinter = new SimpleInterestPrinter(amountInvestmentCalculator);
        simpleInterestPrinter.readPrincipalAmount();
        simpleInterestPrinter.readRateOfInterest();
        simpleInterestPrinter.readNumberOfYears();
        simpleInterestPrinter.printSimpleInterest();
    }
}
