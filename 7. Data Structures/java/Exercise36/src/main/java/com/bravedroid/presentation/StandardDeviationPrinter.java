package com.bravedroid.presentation;

import com.bravedroid.domain.StandardDeviationCalculator;
import com.bravedroid.util.Logger;
import com.bravedroid.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StandardDeviationPrinter {
  private final Logger logger;
  private BufferedReader input;
  private List<Double> numbers = new ArrayList<>();

  public StandardDeviationPrinter(Logger logger) {
    this.logger = logger;
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  public void printStandardDeviation() throws IOException {
    while (true) {
      Printer.print("Enter a number :");
      String responseTime = input.readLine();
      if (mustExitMethod(responseTime.trim())) {
        throw new MustExitException();
      } else if (isBlank(responseTime)) {
        logger.log(numbers);
        Printer.print("Don't enter a blank name ");
      } else if (!isNumeric(responseTime.trim()) && !responseTime.trim().equals("done")) {
        logger.log(numbers);
        Printer.print("Input is not numeric ");
      } else {
        if (isNumeric(responseTime.trim())) {
          double timeInMilliseconds = Double.parseDouble(responseTime.trim());
          numbers.add(timeInMilliseconds);
          logger.log(numbers);
        } else {
          printStatistics();
          break;
        }
      }
    }
  }

  private void printStatistics() {
    StandardDeviationCalculator standardDeviationCalculator = new StandardDeviationCalculator(numbers);
    final double mean = standardDeviationCalculator.calculateAverage();
    final double minimum = standardDeviationCalculator.findMinimum();
    final double maximum = standardDeviationCalculator.findMaximum();
    final double variance = standardDeviationCalculator.getVariance(mean);
    final double standardDeviation = standardDeviationCalculator.getStandardDeviation(variance);

    Printer.print("The average is " + mean);
    Printer.print("The minimum is " + minimum);
    Printer.print("The maximum is " + maximum);
    Printer.print("The standard deviation is " + standardDeviation);
  }

  private boolean isNumeric(String input) {
    boolean isNumeric = true;
    try {
      Long.parseLong(input);
    } catch (IllegalArgumentException ex) {
      isNumeric = false;
    }
    return isNumeric;
  }

  private boolean isBlank(String value) {
    return value.trim().equals("");
  }

  private boolean mustExitMethod(String input) {
    return input.equals("exit");
  }

  public static class MustExitException extends RuntimeException {
    MustExitException() {
      super("user requested exit exception");
    }
  }
}
