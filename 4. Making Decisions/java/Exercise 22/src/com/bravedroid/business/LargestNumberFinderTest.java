package com.bravedroid.business;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LargestNumberFinderTest {
    private LargestNumberFinder SUT;

    @Before
    public void setUp() {
        SUT = new LargestNumberFinder();
    }

    @Test
    public void findLargestNumber() {
        double returnedValue = SUT.findLargestNumber(1.5, 55.9, 9.4578);
        double expectedValue = 55.9;
        double delta = 0;
        assertEquals(expectedValue, returnedValue, delta);
    }
}
