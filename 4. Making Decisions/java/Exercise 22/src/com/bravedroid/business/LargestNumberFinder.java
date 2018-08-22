package com.bravedroid.business;

public class LargestNumberFinder {
  public double findLargestNumber(double num1, double num2, double num3) {
    double largest = num1;
    if (num2 > largest) {
      largest = num2;
    }
    if (num3 > largest) {
      largest = num3;
    }
    return largest;
  }
}
