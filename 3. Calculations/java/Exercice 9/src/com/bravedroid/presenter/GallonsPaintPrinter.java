package com.bravedroid.presenter;

import com.bravedroid.businesslogic.GallonPaintCalculator;
import com.bravedroid.businesslogic.GallonPaintVM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GallonsPaintPrinter {
    private static final String REQUEST_MESSAGE_LENGTH = "What is the length of the room in feet?";
    private static final String REQUEST_MESSAGE_WIDTH = "What is the width of the room in feet?";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private BufferedReader input;
    private GallonPaintCalculator GallonPaintCalculator;
    private double lengthInFeet;
    private double widthInFeet;
    private boolean mustExit;

    public GallonsPaintPrinter(GallonPaintCalculator GallonPaintCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.GallonPaintCalculator = GallonPaintCalculator;
    }

    public void readLengthInFeet() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_LENGTH);
        try {
            String lengthInFeetString = input.readLine();
            if (lengthInFeetString.equals("exit")) {
                mustExit = true;
                return;
            }
            lengthInFeet = Double.parseDouble(lengthInFeetString);
            validateNumIsGreaterThanZero(lengthInFeet);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readLengthInFeet();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readLengthInFeet();
        }
    }

    public void readWidthInFeet() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_WIDTH);
        try {
            String widthInFeetString = input.readLine();
            if (widthInFeetString.equals("exit")) {
                mustExit = true;
                return;
            }
            widthInFeet = Double.parseDouble(widthInFeetString);
            validateNumIsGreaterThanZero(widthInFeet);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readWidthInFeet();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readWidthInFeet();
        }
    }

    public void printGallonsPaint() {
        if (mustExit) return;
        GallonPaintVM vm = GallonPaintCalculator.calculateGallonPaintVM(lengthInFeet, widthInFeet);
        double SquareFeet = vm.getSquareFeet();
        int gallonPaint = vm.getCountGallonPaint();
        System.out.println("\n" +
                "You will need to purchase " + gallonPaint + " gallons of\n" +
                "\u200B \n" +
                "paint to cover " + SquareFeet + " square feet.");
    }

    private void validateNumIsGreaterThanZero(double number) {
        if (number < 1)
            throw new IllegalArgumentException("Input value should be greater than zero!! ");
    }
}
