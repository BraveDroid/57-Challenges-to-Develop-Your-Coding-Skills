package com.bravedroid.businesslogic;

public class BMICalculator {
    public double calculateBMI(double weight, double height) {
        return (weight / (height * height)) * 703;
    }
}
