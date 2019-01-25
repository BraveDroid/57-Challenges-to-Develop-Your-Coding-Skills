package com.bravedroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AddingNumbersPrinter {
  private BufferedReader input;

  AddingNumbersPrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  void readNumber() throws IOException {
    int sum = 0;
    int i = 0;
    while (i < 5) {
      System.out.println("i: "+i);
      System.out.println("Enter A Number : ");
      String inputFromUser = input.readLine();
      if (mustExit(inputFromUser)) {
        return;
      }
      if (isValidInput(inputFromUser)) {
        int numberFromUser = Integer.parseInt(inputFromUser);
        sum += numberFromUser;
        i++;
      }
    }
    System.out.println("The Total is " + sum);
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
    return userInput.equals("exit");
  }
}
