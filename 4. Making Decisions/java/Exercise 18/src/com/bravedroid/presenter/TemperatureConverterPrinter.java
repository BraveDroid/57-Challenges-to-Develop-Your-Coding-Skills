package com.bravedroid.presenter;

import com.bravedroid.businesslogic.TemperatureConverterCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TemperatureConverterPrinter {
    private static final String REQUEST_MESSAGE_CHOICE_TO_CONVERT = "Press C to convert from Fahrenheit to Celsius." + "\n"
            + "Press F to convert from Celsius to Fahrenheit.";
    private static final String ERROR_MESSAGE_NOT_NUMERIC_INPUT = " the value entered is not numeric or not an integer.";

    private TemperatureConverterCalculator temperatureConverterCalculator;
    private boolean mustExit;
    private String choiceToConvert;
    private Double temperature;
    private BufferedReader input;

    public TemperatureConverterPrinter(TemperatureConverterCalculator temperatureConverterCalculator) {
        input = new BufferedReader(new InputStreamReader(System.in));
        this.temperatureConverterCalculator = temperatureConverterCalculator;
    }

    public void readChoiceToConvert() throws IOException {
        if (mustExit) return;
        System.out.println(REQUEST_MESSAGE_CHOICE_TO_CONVERT);
        choiceToConvert = input.readLine();
        if (choiceToConvert.equals("exit")) {
            mustExit = true;
            return;
        }
        if (choiceToConvert.equals("C") || choiceToConvert.equals("F")) {
            System.out.println("Your choice:" + choiceToConvert);
        } else {
            System.out.println("Enter a valid choice (C/F)in UpperCase");
            readChoiceToConvert();
        }
    }

    public void readTemperature() throws IOException {
        if (mustExit) return;
        if (choiceToConvert.equals("F")) {
            System.out.println("Please enter the temperature in Celsius: ");
        } else if (choiceToConvert.equals("C")) {
            System.out.println("Please enter the temperature in Fahrenheit: ");
        }
        try {
            String temperatureInString = input.readLine();
            if (temperatureInString.equals("exit")) {
                mustExit = true;
                return;
            }
            temperature = Double.parseDouble(temperatureInString);
        } catch (NumberFormatException ex) {
            System.out.println(ERROR_MESSAGE_NOT_NUMERIC_INPUT);
            readTemperature();
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            readTemperature();
        }
    }

    public void printTemperatureConverter() {
        if (mustExit) return;
        double temperatureConverterToCelsius = temperatureConverterCalculator.calculateTemperatureConverterToCelsius(temperature);
        double temperatureConverterToFahrenheit = temperatureConverterCalculator.calculateTemperatureConverterToFahrenheit(temperature);
        temperatureConverterToCelsius = Double.parseDouble(new DecimalFormat("##.##").format(temperatureConverterToCelsius));
        temperatureConverterToFahrenheit = Double.parseDouble(new DecimalFormat("##.##").format(temperatureConverterToFahrenheit));

        boolean condition = choiceToConvert.equals("C");
        String outputCelsius = "The temperature in Celsius is " + temperatureConverterToCelsius;
        String outputFahrenheit = "The temperature in Fahrenheit is " + temperatureConverterToFahrenheit;
        String returnedOutput = (condition) ? outputCelsius : outputFahrenheit;
        System.out.println(returnedOutput);
    }
}
