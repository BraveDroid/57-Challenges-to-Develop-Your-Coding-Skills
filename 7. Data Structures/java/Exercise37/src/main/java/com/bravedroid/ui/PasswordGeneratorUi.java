package com.bravedroid.ui;

import com.bravedroid.domain.PasswordGenerator;
import com.bravedroid.util.ClipBoard;
import com.bravedroid.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordGeneratorUi {
  private PasswordGenerator passwordGenerator;
  private BufferedReader input;

  public PasswordGeneratorUi(PasswordGenerator passwordGenerator) {
    input = new BufferedReader(new InputStreamReader(System.in));
    this.passwordGenerator = passwordGenerator;
  }

  public void generatePassword() throws IOException {
    int minimumLength = promptPasswordInformation("What's the minimum length? ");
    int punctCount = promptPasswordInformation("How many special characters?");
    int digitCount = promptPasswordInformation("How many numbers?");

    Printer.print("Your password is");
    final String password = passwordGenerator.rearrangePassword(minimumLength, punctCount, digitCount);
    Printer.print(password);

    ClipBoard.addToClipBoard1(password);
  }


  private int promptPasswordInformation(String Msg) throws IOException {
    while (true) {
      Printer.print(Msg);
      String inputFromUser = input.readLine();
      if (mustExitMethod(inputFromUser.trim())) {
        throw new MustExitException();
      } else if (isBlank(inputFromUser.trim())) {
        Printer.print("Don't enter a blank name ");
      } else if (!isNumeric(inputFromUser.trim())) {
        Printer.print("Input is not numeric ");
      } else {
        if (isNegativeOrZero(inputFromUser.trim())) {
          Printer.print(" zero and negative numbers are not allowed here !!!");
        } else {
          return Integer.parseInt(inputFromUser.trim());
        }
      }
    }
  }

  private boolean isNegativeOrZero(String input) {
    int num = Integer.parseInt(input);
    return num <= 0;
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
