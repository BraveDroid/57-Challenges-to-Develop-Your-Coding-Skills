package com.bravedroid.businesslogic.util;

public class NumberFormatHelper {
    public double formatNumberToTheNearestCent(double number) {
        double numberRounded = Math.round(number * 100);
        return numberRounded / 100;
    }
}
