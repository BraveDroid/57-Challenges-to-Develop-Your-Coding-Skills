package com.bravedroid.businesslogic;

public class ConvertsCurrencyCalculator {
    public double calculateConvertsCurrency(double amountFrom, double rateFrom){
        return (amountFrom*rateFrom)/100;
    }
}
