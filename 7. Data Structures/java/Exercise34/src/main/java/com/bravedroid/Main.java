package com.bravedroid;

import com.bravedroid.util.Printer;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    EmployeeListRemoval employeeListRemoval = new EmployeeListRemoval();
    try {
      employeeListRemoval.promptForEmployeeNameToRemove();
    } catch (EmployeeListRemoval.MustExitException ignored) {
      Printer.print("BYE BYE :)");
    }
  }
}
