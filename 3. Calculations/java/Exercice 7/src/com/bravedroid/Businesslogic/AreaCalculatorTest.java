package com.bravedroid.Businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AreaCalculatorTest {
    //given
    private AreaCalculator SUT;

    @Before
    public void setup() {
        SUT = new AreaCalculator();
    }

    @Test
    public void calculateAreaInFeet_correctInput_areaInFeetReturned() {
        //when
        double resultReturned = SUT.calculateAreaInFeet(0.2, 40.2);
        double expectedResult = 8.04;
        //then
        double delta = 0.001;
        assertEquals(expectedResult, resultReturned, delta);
    }

    @Test
    public void calculateAreaInMeters_correctInput_areaInMeteresReturned() {
        //when
        double resultReturned = SUT.calculateAreaInMeters(8.04, 0.09290304);
        double expectedResult = 0.747;
        //then
        double delta = 0.001;
        assertEquals(expectedResult, resultReturned, delta);
    }
}