package com.bravedroid.domain;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class StandardDeviationCalculator {
  private List<Double> numbers;

  public StandardDeviationCalculator(List<Double> numbers) {
    this.numbers = numbers;
  }

  public double calculateAverage() {
    int sum = 0;
    for (Double item : numbers) {
      sum += item;
    }
    return sum / numbers.size();
  }

  public double findMinimum() {
    double min = numbers.get(0);
    for (double i : numbers) {
      min = Math.min(min, i);
    }
    return min;
  }

  public double findMaximum() {
    double max = numbers.get(0);
    for (double i : numbers) {
      max = Math.max(max, i);
    }
    return max;
  }

  public double getVariance(double mean) {
    double temp = 0;
    for (double a : numbers) {
      temp += (a - mean) * (a - mean);
    }
    NumberFormat numberFormatter = new DecimalFormat("##.##");
    return Double.parseDouble(numberFormatter.format((temp / (numbers.size() - 1))));
  }

  public double getStandardDeviation(double variance) {
    NumberFormat numberFormatter = new DecimalFormat("##.##");
    return Double.parseDouble(numberFormatter.format(Math.sqrt(getVariance(variance))));
  }
}
