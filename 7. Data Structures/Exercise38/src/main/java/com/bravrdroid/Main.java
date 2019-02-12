package com.bravrdroid;

import com.bravrdroid.domain.EvenNumberDetector;
import com.bravrdroid.presentation.FilteredValuesPrinter;
import com.bravrdroid.util.InputValidator;
import com.bravrdroid.util.Logger;
import com.bravrdroid.util.Printer;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    boolean isDebug = false;
    Logger logger = new Logger(isDebug);
    EvenNumberDetector evenNumberDetector = new EvenNumberDetector();
    FilteredValuesPrinter filteredValuesPrinter = new FilteredValuesPrinter(evenNumberDetector, logger);
    try {
      filteredValuesPrinter.printEvenNumbers();
    } catch (InputValidator.MustExitException ignored) {
      Printer.print("GOOD BYE :)");
    }
  }
}

