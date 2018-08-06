package com.bravedroid.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AmountInvestmentCalculatorTest {
    AmountInvestmentCalculator SUT;

    @Before
    public void setup() {
        SUT = new AmountInvestmentCalculator();
    }

    @Test
    public void calculateAmountInvestment_correctInput_amountInvestmentIsReturned() {
        double returnedValue = SUT.calculateAmountInvestment(1500, 4.3, 4);
        double expectedValue = 1758;
        double delta = 0.001;
        assertEquals(expectedValue, returnedValue, delta);
    }
}
