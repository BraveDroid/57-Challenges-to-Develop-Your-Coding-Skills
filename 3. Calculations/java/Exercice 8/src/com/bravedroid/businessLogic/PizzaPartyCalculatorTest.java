package com.bravedroid.businessLogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PizzaPartyCalculatorTest {
    //given
    private PizzaPartyCalculator SUT;

    @Before
    public void setUp() {
        SUT = new PizzaPartyCalculator();
    }

    @Test
    public void calculateAllPizzaSlices_correctInput_returnAllPizzaSlices() {
        //when
        int returnedValue = SUT.calculateAllPizzaSlices(2);
        int expectedValue = 16;
        //then
        assertEquals(expectedValue, returnedValue);
    }

    @Test
    public void calculatePiecesOfPizzaPerPerson_correctInput_returnPieces_Of_PizzaPerPeron() {
        //when
        int returnedValue = SUT.calculatePiecesOfPizzaPerPerson(2, 16);
        int expectedValue = 8;
        //then
        assertEquals(expectedValue, returnedValue);

    }

    @Test
    public void calculateLeftoverPieces_correctInput_ReturnLeftoverPieces() {
        //when
        int returnedValue = SUT.calculateLeftoverPieces(8, 16, 2);
        int expectedValue = 0;
        //then
        assertEquals(expectedValue, returnedValue);
    }
}