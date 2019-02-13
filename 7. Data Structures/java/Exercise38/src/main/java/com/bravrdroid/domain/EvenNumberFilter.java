package com.bravrdroid.domain;

import java.util.Arrays;

public class EvenNumberFilter {
  public int[] filterEvenNumbers(int[] inputNumbers) {
    return Arrays.stream(inputNumbers).filter(value -> value % 2 == 0).toArray();
  }
}
