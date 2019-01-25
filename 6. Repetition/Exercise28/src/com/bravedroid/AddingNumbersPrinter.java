package com.bravedroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AddingNumbersPrinter {
  private int numberFromUser;
  private boolean mustExit;
  private BufferedReader input;

  AddingNumbersPrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  void readNumber() throws IOException {
    int sum = numberFromUser;
    int i = 0;
    while (i < 5) {
      if (mustExit) {
        return;
      }
      System.out.println("Enter A Number : ");
      String inputFromUser = input.readLine();

      if (mustExit(inputFromUser)) {
        mustExit = true;
      } else if (!isValidInput(inputFromUser)) {
        readNumber();
      } else if (isValidInput(inputFromUser)) {
        numberFromUser = Integer.parseInt(inputFromUser);
        sum += numberFromUser;
      }
      i++;
    }
    System.out.println("The Total is " + sum);
    mustExit = true;
  }

  private boolean isValidInput(String number) {
    boolean isValid;
    try {
      Integer.parseInt(number);
      isValid = true;
    } catch (IllegalArgumentException ex) {
      System.out.println("illegal argument");
      isValid = false;
    }
    return isValid;
  }

  private boolean mustExit(String userInput) {
    mustExit = userInput.equals("exit");
    return mustExit;
  }
}
