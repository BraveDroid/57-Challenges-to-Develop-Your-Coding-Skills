package com.bravedroid.util.statistics;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class StandardDeviationCalculations {


  public static double calculateAverage(List<Double> numbers) {
    int sum = 0;
    for (Double item : numbers) {
      sum += item;
    }
    return sum / numbers.size();
  }

  public static double findMinimum(List<Double> numbers) {
    double min = numbers.get(0);
    for (double i : numbers) {
      min = Math.min(min, i);
    }
    return min;
  }

  public static double findMaximum(List<Double> numbers) {
    double max = numbers.get(0);
    for (double i : numbers) {
      max = Math.max(max, i);
    }
    return max;
  }

  public static double getVariance(List<Double> numbers,double mean) {
    double temp = 0;
    for (double a : numbers) {
      temp += (a - mean) * (a - mean);
    }
    NumberFormat numberFormatter = new DecimalFormat("##.##");
    return Double.parseDouble(numberFormatter.format((temp / (numbers.size() - 1))));
  }

  public static  double getStandardDeviation(List<Double> numbers,double variance) {
    NumberFormat numberFormatter = new DecimalFormat("##.##");
    return Double.parseDouble(numberFormatter.format(Math.sqrt(getVariance(numbers,variance))));
  }
}
