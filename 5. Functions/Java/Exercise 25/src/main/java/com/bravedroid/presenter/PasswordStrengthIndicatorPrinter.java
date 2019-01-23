package com.bravedroid.presenter;

import com.bravedroid.businesslogic.PasswordStrengthIndicator;
import com.bravedroid.businesslogic.exceptions.BadPasswordFormatException;
import com.bravedroid.businesslogic.utils.CharTypeSumStruct;

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

  private String indicatePasswordStrength(String password) {
    CharTypeSumStruct vm = passwordStrengthIndicator.getSumCharTypeEnum(password);

    return getPasswordComplexityMsg(vm);
  }

  public void printPasswordStrengthIndicator() {
    if (mustExit) return;
    try {
      String message = indicatePasswordStrength(password);
      System.out.println(message);
    } catch (BadPasswordFormatException ex) {
      System.out.println(ex.getMessage() + "!!!");
    }
  }

  private String getPasswordComplexityMsg(CharTypeSumStruct vm) {
    StringBuilder messageToPrint = new StringBuilder();
    switch (passwordStrengthIndicator.getPasswordComplexity(vm)) {
      case VERY_WEAK_PASSWORD:
        messageToPrint.append("The password ")
                .append("\'")
                .append(password)
                .append("\'")
                .append(" is a very weak password.");
        break;
      case WEAK_PASSWORD:
        messageToPrint.append("The password ")
                .append("\'")
                .append(password)
                .append("\'")
                .append(" is a weak password.");
        break;
      case STRONG_PASSWORD:
        messageToPrint.append("The password ")
                .append("\'").append(password)
                .append("\'")
                .append(" is a strong password.");
        break;
      case VERY_STRONG_PASSWORD:
        messageToPrint.append("The password ")
                .append("\'")
                .append(password)
                .append("\'")
                .append(" is a very strong password.");
        break;
      case UNKNOWN_CHARACTER_PASSWORD:
        messageToPrint.append("The password ")
                .append("\'")
                .append(password)
                .append("\'")
                .append(" unknown characters are entered !!!");
        break;
      default:
        throw new BadPasswordFormatException("Invalid Password Format");
    }
    return messageToPrint.toString();
  }
}
