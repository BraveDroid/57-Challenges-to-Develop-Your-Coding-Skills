package com.bravedroid;

import com.bravedroid.util.Logger;
import com.bravedroid.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class PickingAWinner {
  private final Logger logger;
  private BufferedReader input;
  private Set<String> candidatesNames = new HashSet<>();

  PickingAWinner(Logger logger) {
    input = new BufferedReader(new InputStreamReader(System.in));
    this.logger = logger;
  }

  void promptWinnerName() throws IOException {
    final Random rand = new Random();
    while (true) {
      Printer.print("Enter a name: ");
      String candidateName = input.readLine();
      if (mustExitMethod(candidateName.trim())) {
        throw new MustExitException();
      } else if (isNumeric(candidateName)) {
        logger.log(candidatesNames);
        Printer.print("Invalid Input");
      } else if (isBlankNotEmpty(candidateName)) {
        logger.log(candidatesNames);
        Printer.print("Don't enter a blank name");
      } else if (!isEmpty(candidateName) && !candidatesNames.add(candidateName.trim())) {
        logger.log(candidatesNames);
        Printer.print("Name already exist");
      } else if (isEmpty(candidateName) && candidatesNames.isEmpty()) {
        Printer.print("Enter at least one ");
        logger.log(candidatesNames);
      } else if (isEmpty(candidateName)) {
        final int randomIndex = rand.nextInt(candidatesNames.size());
        Object[] candidatesArray = candidatesNames.toArray();
        Printer.print("THE WINNER IS : " + candidatesArray[randomIndex].toString());
        break;
      }
    }
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

  private boolean isBlankNotEmpty(String value) {
    return value.trim().equals("") && value.length() > 0;
  }

  private boolean mustExitMethod(String input) {
    return input.equals("exit");
  }

  private boolean isEmpty(String value) {
    return value.equals("");
  }

  static class MustExitException extends RuntimeException {
    MustExitException() {
      super("user requested exit exception");
    }
  }
}
