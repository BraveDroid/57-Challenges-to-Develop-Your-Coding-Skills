package com.bravedroid.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StandardDeviationCalculatorTest {
  private StandardDeviationCalculator SUT;
  private List<Double> numbers = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    SUT = new StandardDeviationCalculator(numbers);
    numbers.add(100.0);
    numbers.add(200.0);
    numbers.add(1000.0);
    numbers.add(300.0);
  }

  @Test
  public void calculateAverage() {
    double result = SUT.calculateAverage();
    double expected = 400.0;
    assertEquals(expected, result, 0.001);
  }

  @Test
  public void calculateMinimum() {
    double result = SUT.findMinimum();
    double expected = 100.0;
    assertEquals(expected, result, 0.001);
  }

  @Test
  public void calculateMaximum() {
    double result = SUT.findMaximum();
    double expected = 1000.0;
    assertEquals(expected, result, 0.001);
  }

  @Test
  public void getVariance() {
    double result = SUT.getVariance(400.0);
    double expected = 166666.67;
    assertEquals(expected, result, 0.001);
  }

  @Test
  public void getStandardDeviation() {
    double result = SUT.getStandardDeviation(166666.67);
    double expected = 191988.65;
    assertEquals(expected, result, 0.001);
  }
}
