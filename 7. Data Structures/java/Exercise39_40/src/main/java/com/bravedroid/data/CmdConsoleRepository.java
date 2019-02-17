package com.bravedroid.data;

import com.bravedroid.domain.Employee;
import com.bravedroid.presentation.ReaderCmd;
import com.bravedroid.util.Printer;
import com.bravedroid.util.ValidateInput.MustExitException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.bravedroid.util.ValidateInput.isBlank;
import static com.bravedroid.util.ValidateInput.mustExitMethod;

public class CmdConsoleRepository implements Repository {
  private ReaderCmd reader;

  public CmdConsoleRepository(ReaderCmd reader) {
    this.reader = reader;
  }
  @Override
  public List<Employee> getRecords() throws IOException {
    final  int READ_INFINITELY = -1;
    return getRecords(READ_INFINITELY);
  }
  public List<Employee> getRecords(int max_read_times) throws IOException {
    List<Employee> employeeList = new ArrayList<>();
    int i = 0;
    while (true) {
      if ( i == max_read_times) {
        break;
      }
      i++;
      String inputFromUser = reader.readInput();
      if (mustExitMethod(inputFromUser)) {
        throw new MustExitException();
      } else if (isBlank(inputFromUser)) {
        Printer.print("Inputs should not be empty!!");
      } else if (!isSeparatedByWhiteSpace(inputFromUser) && !inputFromUser.equals("done")) {
        Printer.print("Inputs must be separated by whitespace");
      } else {
        final String[] inputArray = inputFromUser.trim().split(" ");
        if (!hasNecessaryData(inputArray)) {
          Printer.print("invalid input you must enter at least 3 data");
        } else if (hasNecessaryData(inputArray)) {
          switch (inputArray.length) {
            case 4:
              employeeList.add(new Employee(inputArray[0], inputArray[1], inputArray[2], inputArray[3]));
              break;
            case 3:
              employeeList.add(new Employee(inputArray[0], inputArray[1], inputArray[2], ""));
              break;
          }
        }
        if (employeeList.size() > 1 && inputFromUser.equals("done")) {
          break;
        }
      }
    }
    return employeeList;
  }

  boolean isSeparatedByWhiteSpace(String recordsInput) {
    boolean containWhiteSpace;
    try {
      final String[] splitData = recordsInput.trim().split(" ");
      containWhiteSpace = splitData.length > 1;

    } catch (IllegalArgumentException ex) {
      containWhiteSpace = false;
    }
    return containWhiteSpace;
  }

  boolean hasNecessaryData(String[] inputArray) {
    return inputArray.length == 4 || inputArray.length == 3;
  }
}
