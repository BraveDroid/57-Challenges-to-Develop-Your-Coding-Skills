package com.bravedroid.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BMICalculatorTest {
    BMICalculator SUT;

    @Before
    public void setup() {
        SUT = new BMICalculator();
    }

    @Test
    public void calculateBMI_correctInputs_BMIReturned() {
        double returnedBMI = SUT.calculateBMI(150, 67);
        double expected = 23.49;
        double delta = 0.001;
        assertEquals(expected, returnedBMI, delta);
    }
}
