package com.bravedroid.businesslogic;

public class BMICalculator {
    public double calculateBMI(double weight, double height) {
        final int MYSTERIOUS_NUMBER = 703;
        return (weight / (height * height)) * MYSTERIOUS_NUMBER;
    }
}
