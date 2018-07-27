package com.bravedroid.application;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConversionAdderTest {
    //given
    private ConversionAdder SUT;

    @Before
    public void setup() {
        SUT = new ConversionAdder();
    }

    @Test
    public void addConversions_correctInputsEntered_conversionReturned() {
        //when
        String returnedSolution = SUT.addConversion(5, 5);
        String expectedsolution =
                "5 + 5 = 10\n" + "5 - 5 = 0\n" + "5 * 5 = 25\n" + "5 / 5 = 1";
        //then
        assertEquals(expectedsolution, returnedSolution);
    }
}