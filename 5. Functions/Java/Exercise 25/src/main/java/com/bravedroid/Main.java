package com.bravedroid;

import com.bravedroid.businesslogic.PasswordStrengthIndicator;
import com.bravedroid.presenter.PasswordStrengthIndicatorPrinter;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    PasswordStrengthIndicator passwordStrengthIndicator = new PasswordStrengthIndicator();
    PasswordStrengthIndicatorPrinter passwordStrengthIndicatorPrinter = new PasswordStrengthIndicatorPrinter(passwordStrengthIndicator);
    passwordStrengthIndicatorPrinter.readPassword();
    passwordStrengthIndicatorPrinter.printPasswordStrengthIndicator();
  }
}
