package com.bravedroid.businesslogic.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NumberFormatHelperTest {
    private NumberFormatHelper SUT;

    @Before
    public void setUp() {
        SUT = new NumberFormatHelper();
    }

    @Test
    public void formatNumberToTheNearestCent_simpleInput_roundedOutput() {
        double numberInput = 0.566d;
        double returnedValue = SUT.formatNumberToTheNearestCent(numberInput);
        double expectedValue = 0.57;
        double delta = 0;
        assertEquals(expectedValue, returnedValue, delta);
    }
}
