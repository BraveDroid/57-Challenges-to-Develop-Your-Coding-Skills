package com.bravedroid.presenter;

import com.bravedroid.Businesslogic.AreaCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class AreaPrinter {
    private String lengthInFeetString;
    private String widthInFeetString;
    private AreaCalculator areaCalculator;

    public AreaPrinter(AreaCalculator areaCalculator) {
        this.areaCalculator = areaCalculator;
    }

    public void readSizes() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What is the length of the room in feet?");
        lengthInFeetString = input.readLine();
        System.out.println("What is the width of the room in feet?");
        widthInFeetString = input.readLine();
    }

    public void printArea() {
        final double conversion = 0.09290304;
        double lengthInFeet;
        double widthInFeet;
        try {
            lengthInFeet = Double.parseDouble(lengthInFeetString);
            widthInFeet = Double.parseDouble(widthInFeetString);

        } catch (NumberFormatException ex) {
            System.out.println(" the value entered is not numeric !!!");
            return;
        }

        if (lengthInFeet < 0 || widthInFeet < 0) {
            System.out.println("your inputs are not valid !!! ");
            return;
        }
        System.out.println("You entered dimensions of " + lengthInFeet + " feet by " + widthInFeet + " feet.");
        System.out.println("The area is : ");

        double areaInFeet = areaCalculator.calculateAreaInFeet(lengthInFeet, widthInFeet);
        areaInFeet = Double.parseDouble(new DecimalFormat("##.###").format(areaInFeet));
        System.out.println(areaInFeet + " square feet");

        double areaInMeters = areaCalculator.calculateAreaInMeters(areaInFeet, conversion);
        areaInMeters = Double.parseDouble(new DecimalFormat("##.###").format(areaInMeters));
        System.out.println(areaInMeters + " square meters");
    }
}
