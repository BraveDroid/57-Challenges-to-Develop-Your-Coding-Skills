package com.bravedroid.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class gallonPaintCalculatorTest {
    private GallonPaintCalculator SUT;

    @Before
    public void setup() {
        SUT = new GallonPaintCalculator();
    }

    @Test
    public void calculateGallonPaintVM_correctInput_gallonPaintReturned() {
        GallonPaintVM vm = SUT.calculateGallonPaintVM(100, 2);
        GallonPaintVM expectedVM = new GallonPaintVM();
        expectedVM.setSquareFeet(200);
        expectedVM.setCountGallonPaint(1);
        assertEquals(expectedVM, vm);
    }

    @Test
    public void calculateGallonPaint_correctInput_gallonPaintReturned() {
        int returnedValue = SUT.calculateGallonPaint(300, 2);
        int expectedValue = 2;
        assertEquals(expectedValue, returnedValue);
    }
}