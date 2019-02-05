package com.bravedroid;

import com.bravedroid.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Magic8BallGame {
  private String[] possibleResponses = {"Yes", "No", "Maybe", "Ask again later"};
  private BufferedReader input;

  Magic8BallGame() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  void promptForQuestion() throws IOException {
    Random rand = new Random();
    Printer.print("What's your Question ?");
    String userQuestion = input.readLine();
    if (mustExitMethod(userQuestion)) {
      throw new MustExitException();
    } else if (isNumeric(userQuestion)) {
      Printer.print("Ask again later");
    } else {
      final int i = rand.nextInt(possibleResponses.length);
      Printer.print(possibleResponses[i]);
    }
  }

  private boolean isNumeric(String input) {
    boolean isNumeric = true;
    try {
      Integer.parseInt(input);
    } catch (IllegalArgumentException ex) {
      isNumeric = false;
    }
    return isNumeric;
  }

  private boolean mustExitMethod(String input) {
    return input.equals("exit");
  }

  static class MustExitException extends RuntimeException {
    MustExitException() {
      super("user requested exit exception");
    }
  }
}
