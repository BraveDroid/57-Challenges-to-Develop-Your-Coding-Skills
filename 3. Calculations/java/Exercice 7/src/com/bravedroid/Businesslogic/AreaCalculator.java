package com.bravedroid.Businesslogic;

public class AreaCalculator {

    public int calculateAreaInFeet(int length, int width) {
        return length * width;
    }

    public double calculateAreaInMeters(int areaInFeet, double conversion) {
        return areaInFeet * conversion;
    }
}
