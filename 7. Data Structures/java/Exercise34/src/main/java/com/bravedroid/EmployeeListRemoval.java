package com.bravedroid;

import com.bravedroid.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EmployeeListRemoval {
  private List<String> employeeNames = new ArrayList<>();
  private BufferedReader input;

  EmployeeListRemoval() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  void promptForEmployeeNameToRemove() throws IOException {
    printEmployeeList();
    while (true) {
      Printer.print("Enter an employee name to remove:");
      String nameToRemove = input.readLine();
      if (mustExitMethod(nameToRemove)) {
        throw new MustExitException();
      } else if (!employeeNames.contains(nameToRemove)) {
        Printer.print("unknown employee name !!");
      } else {
        employeeNames.remove(nameToRemove);
        for (String item : employeeNames) {
          Printer.print(item);
        }
        break;
      }
    }
  }

  private void printEmployeeList() {
    employeeNames.add("John Smith");
    employeeNames.add("Jackie Jackson");
    employeeNames.add("Chris Jones");
    employeeNames.add("Amanda Cullen");
    employeeNames.add("Jeremy Goodwin");
    Printer.print("There are 5 employees:");
    for (String item : employeeNames) {
      Printer.print(item);
    }
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
