package com.bravrdroid;

import com.bravrdroid.domain.EvenNumberFilter;
import com.bravrdroid.presentation.FilteredValuesValidator;
import com.bravrdroid.presentation.ReaderCmd;
import com.bravrdroid.util.InputValidator;
import com.bravrdroid.util.Logger;
import com.bravrdroid.util.Printer;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    boolean isDebug = false;

    //load dependencies
    Logger logger = new Logger(isDebug);
    EvenNumberFilter evenNumberFilter = new EvenNumberFilter();
    ReaderCmd reader = new ReaderCmd();

    //inject dependencies
    FilteredValuesValidator filteredValuesValidator = new FilteredValuesValidator(reader, evenNumberFilter, logger);

    try {
      Printer.print(filteredValuesValidator.printEvenNumbers());
    } catch (InputValidator.MustExitException ignored) {
      Printer.print("GOOD BYE :)");
    }
  }
}

