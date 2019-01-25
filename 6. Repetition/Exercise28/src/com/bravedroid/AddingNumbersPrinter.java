package com.bravedroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AddingNumbersPrinter {
  private BufferedReader input;
  private int sum;
  private String inputFromUser;

  AddingNumbersPrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }
//variant with do{} while()
  void readNumber() throws IOException {
    int sum = 0;
    int i = 0;
    do {
      //useful for debug
      //System.out.println("i: " + i);
      System.out.println("Enter A Number : ");
      inputFromUser = input.readLine();
      if (mustExit(inputFromUser)) {
        return;
      }
      if (isValidInput(inputFromUser)) {
        int numberFromUser = Integer.parseInt(inputFromUser);
        sum += numberFromUser;
        i++;
      }
    } while (i < 5);
    System.out.println("The Total is " + sum);
  }
  //variant with for()
  void readNumber1() throws IOException {
    for (int i = 0; i < 5; i = incrementValue(i)) {
      //useful for debug
      //System.out.println("i: " + i);
      System.out.println("Enter A Number : ");
      inputFromUser = input.readLine();
      if (mustExit(inputFromUser)) {
        return;
      }
    }
    System.out.println("The Total is " + sum);

  }

  private int incrementValue(int value) {
    if (isValidInput(inputFromUser)) {
      int numberFromUser = Integer.parseInt(inputFromUser);
      sum += numberFromUser;
      value++;
    }
    return value;
  }
  //variant with while()
  void readNumber2() throws IOException {
    int sum = 0;
    int i = 0;
    while (i < 5) {
      //useful for debug
      //System.out.println("i: " + i);
      System.out.println("Enter A Number : ");
      inputFromUser = input.readLine();
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
