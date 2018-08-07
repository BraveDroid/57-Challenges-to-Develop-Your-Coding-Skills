package com.bravedroid.businessLogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {
    private TaxCalculator SUT;

    @Before
    public void setup() {
        SUT = new TaxCalculator();
    }

    @Test
    public void calculateTax() {
        TaxCalculatorVM returnedSolution = SUT.calculateTax(200);
        TaxCalculatorVM expectedSolution = new TaxCalculatorVM();
        expectedSolution.setSubtotal(200);
        expectedSolution.setTax(11);
        expectedSolution.setTotal(211);

        assertEquals(expectedSolution, returnedSolution);
    }
}
