package com.bravedroid.application;

public class ConversionAdder {
    public String addConversion(int firstNumber, int secondNumber) {
        final int sum = firstNumber + secondNumber;
        final int difference = firstNumber - secondNumber;
        final int product = firstNumber * secondNumber;
        final int quotient = firstNumber / secondNumber;

        return firstNumber + " + " + secondNumber + " = " + sum + "\n" +
                firstNumber + " - " + secondNumber + " = " + difference + "\n" +
                firstNumber + " * " + secondNumber + " = " + product + "\n" +
                firstNumber + " / " + secondNumber + " = " + quotient;
    }
}