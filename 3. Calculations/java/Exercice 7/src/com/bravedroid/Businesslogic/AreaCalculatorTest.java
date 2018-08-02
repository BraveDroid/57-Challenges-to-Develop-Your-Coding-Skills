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
        int resultReturned = SUT.calculateAreaInFeet(20, 3);
        int expectedResult = 60;
        //then
        assertEquals(expectedResult, resultReturned);
    }

    @Test
    public void calculateAreaInMeters_correctInput_areaInMeteresReturnde() {
        //when
        double resultReturned = SUT.calculateAreaInMeters(60, 0.09290304);
        double expectedResult = 5.574;
        //then
        double delta = 0.001;
        assertEquals(expectedResult, resultReturned, delta);
    }
}