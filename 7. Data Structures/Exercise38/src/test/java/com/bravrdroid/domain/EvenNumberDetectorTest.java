package com.bravrdroid.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class EvenNumberDetectorTest {
  private EvenNumberFilter SUT;

  @Before
  public void setUp() {
    SUT = new EvenNumberFilter();
  }

  @Test
  public void filterEvenNumbers_arrayWithNoEven_returnEmptyArray() {
    int[] result = SUT.filterEvenNumbers(new int[]{1, 1, 5, 7, 17, 15, 13});
    int[] expected = new int[]{};
    assertArrayEquals(expected, result);
  }

  @Test
  public void filterEvenNumbers_arrayWithEvens_returnArrayOfEvens() {
    int[] result = SUT.filterEvenNumbers(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    int[] expected = new int[]{2, 4, 6, 8};
    assertArrayEquals(expected, result);
  }
}
