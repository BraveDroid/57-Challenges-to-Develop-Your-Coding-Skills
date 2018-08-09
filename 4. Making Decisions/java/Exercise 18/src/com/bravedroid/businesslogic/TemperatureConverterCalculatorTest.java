package com.bravedroid.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureConverterCalculatorTest {
    TemperatureConverterCalculator SUT;

    @Before
    public void setup() {
        SUT = new TemperatureConverterCalculator();
    }

    @Test
    public void calculateTemperatureConverterToCelsius_correctInput_temperatureInCelsius() {
        double returnedValue = SUT.calculateTemperatureConverterToCelsius(41);
        double expectedValue = 5;
        double delta=0.0001;
        assertEquals(expectedValue,returnedValue,delta);
    }

    @Test
    public void calculateTemperatureConverterToFahrenheit_correctInput_temperatureInFahrenheit() {
        double returnedValue = SUT.calculateTemperatureConverterToFahrenheit(5);
        double expectedValue = 41;
        double delta=0.0001;
        assertEquals(expectedValue,returnedValue,delta);
    }
}
