package com.bravedroid.businesslogic;

public class AmountInvestmentCalculator {
    public double calculateAmountInvestment(double principalAmount, double rateOfInterest, int numberOfYears) {
        return (((principalAmount * rateOfInterest) / 100) * numberOfYears) + principalAmount;
    }
}
