package com.bravedroid;

import com.bravedroid.domain.PasswordGenerator;
import com.bravedroid.ui.PasswordGeneratorUi;
import com.bravedroid.util.Logger;
import com.bravedroid.util.Printer;

import java.io.IOException;

public class Main {
  private static boolean isDebug = false;
  public static void main(String[] args) throws IOException {
    Logger logger = new Logger(isDebug);
    PasswordGenerator passwordGenerator = new PasswordGenerator(logger);
    PasswordGeneratorUi passwordGeneratorUi = new PasswordGeneratorUi(passwordGenerator);
    try {
      passwordGeneratorUi.generatePassword();
    } catch (PasswordGeneratorUi.MustExitException ignored) {
      Printer.print("GOOD BYE :)");
    }
  }
}
