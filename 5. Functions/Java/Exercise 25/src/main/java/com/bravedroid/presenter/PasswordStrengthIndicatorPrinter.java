package com.bravedroid.presenter;

import com.bravedroid.businesslogic.PasswordStrengthIndicator;
import com.bravedroid.businesslogic.exceptions.BadPasswordFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PasswordStrengthIndicatorPrinter {
  private boolean mustExit;
  private String password;
  private PasswordStrengthIndicator passwordStrengthIndicator;

  public PasswordStrengthIndicatorPrinter(PasswordStrengthIndicator passwordStrengthIndicator) {
    this.passwordStrengthIndicator = passwordStrengthIndicator;
  }

  public void readPassword() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    if (mustExit) {
      return;
    }
    System.out.println("Enter your password:");
    password = input.readLine();
    if (password.equals("exit")) {
      mustExit = true;
    } else if (password.equals("")) {
      System.out.println("Your enter is empty!");
    }
  }

  public void printPasswordStrengthIndicator() {
    if (mustExit) return;
    try {
      String message = passwordStrengthIndicator.indicatePasswordStrength(password);
      System.out.println(message);
    } catch (BadPasswordFormatException ex) {
      System.out.println(ex.getMessage() + "!!!");
    }
  }
}
