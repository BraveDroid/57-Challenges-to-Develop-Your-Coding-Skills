package com.bravedroid.Businesslogic;

public class AreaCalculator {
    public double calculateAreaInFeet(double length, double width) {
        return length * width;
    }

    public double calculateAreaInMeters(double areaInFeet, double conversion) {
        return areaInFeet * conversion;
    }
}
