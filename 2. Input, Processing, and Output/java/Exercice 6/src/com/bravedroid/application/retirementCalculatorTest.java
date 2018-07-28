package com.bravedroid.application;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class retirementCalculatorTest {
    //given
    private RetirementCalculator SUT;

    @Before
    public void setup() {
        SUT = new RetirementCalculator();
    }

    @Test
    public void calculateRetirementYearsLeft_correctInputCase_returnThirty() {
        //when
        int returnedLiftYears = SUT.calculateRetirementYearsLeft(30, 60);
        int expecterOutout = 30;
        //then
        assertEquals(expecterOutout, returnedLiftYears);
    }

    @Test
    public void calculateyearForRetirement_correctInput_yearForRetirementReturned() {
        //when
        int returnedLiftYears = SUT.calculateYearForRetirement(30, 60);
        int ExpectedOutput = 2048;
        //then
        assertEquals(ExpectedOutput, returnedLiftYears);
    }

    @Test
    public void provideRetirementInfo_correctInput_InfosStringReterned() {
        String returnedValue = SUT.provideRetirementInfo(30, 60);
        String expectedValue = "You have 30 years left until you can retire.\n" +
                "It's 2018, so you can retire in 2048.";
    }
}
