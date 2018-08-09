package com.bravedroid.businesslogic;

public class TemperatureConverterCalculator {
    public double calculateTemperatureConverterToCelsius(double temperatureInFahrenheit) {
        //C=(temperatureInFahrenheit - 32) * 5 / 9
        return (temperatureInFahrenheit - 32) * 5 / 9;
    }

    public double calculateTemperatureConverterToFahrenheit(double temperatureInCelsius) {
        //F= (temperatureInCelsius*9/5)+32
        return ( temperatureInCelsius * 9 / 5)+ 32;
    }
}
