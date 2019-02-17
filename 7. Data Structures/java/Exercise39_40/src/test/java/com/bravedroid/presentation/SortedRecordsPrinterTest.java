package com.bravedroid.presentation;

import org.junit.Before;
import org.junit.Test;

public class SortedRecordsPrinterTest {

  @Before
  public void setUp() {
  }

  @Test
  public void printSortedResult() {
    StringBuilder input = new StringBuilder("james");
    while (input.length() < 17) {
      input.append(" ");
    }
    System.out.println(input.length());
  }
}
