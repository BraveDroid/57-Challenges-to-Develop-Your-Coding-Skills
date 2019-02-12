package com.bravrdroid.domain;

import java.util.ArrayList;
import java.util.List;

public class EvenNumberDetector {
  public int[] filterEvenNumbers(int[] inputNumbers) {
    List<Integer> evens = new ArrayList<>();
    for (Integer item : inputNumbers) {
      if (item % 2 == 0) {
        evens.add(item);
      }
    }
    return fromListToArray((evens));
  }

  private int[] fromListToArray(List<Integer> resultList) {
    final int[] ints = new int[resultList.size()];
    int i = 0;
    for (Integer item : resultList) {
      ints[i++] = item;
    }
    return ints;
  }
}
