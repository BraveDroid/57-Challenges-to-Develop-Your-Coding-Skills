package com.bravedroid;

import com.bravedroid.businesslogic.TemperatureConverterCalculator;
import com.bravedroid.presenter.TemperatureConverterPrinter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TemperatureConverterCalculator temperatureConverterCalculator=new TemperatureConverterCalculator();
        TemperatureConverterPrinter temperatureConverterPrinter=new TemperatureConverterPrinter(temperatureConverterCalculator);
        temperatureConverterPrinter.readChoiceToConvert();
        temperatureConverterPrinter.readTemperature();
        temperatureConverterPrinter.printTemperatureConverter();
    }
}
