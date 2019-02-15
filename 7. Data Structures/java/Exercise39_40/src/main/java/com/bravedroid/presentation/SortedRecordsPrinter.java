package com.bravedroid.presentation;


import com.bravedroid.domain.Employee;
import com.bravedroid.usecases.RecordsSorterLogic;
import com.bravedroid.util.Printer;

import java.util.List;

public class SortedRecordsPrinter {

  private final RecordsSorterLogic sorter;
  private final List<Employee> employeeList;

  public SortedRecordsPrinter(RecordsSorterLogic sorter, List<Employee> employeeList) {
    this.sorter = sorter;
    this.employeeList = employeeList;
  }

  public void printSortedResult() {
    printHeader();
    final List<Employee> list = sorter.sortRecords(employeeList);
    for (Employee item : list) {
      final String name = format(item.getFirstName() + " " + item.getLastName());
      final String position = format(item.getPosition());
      final String separationDate = format(item.getSuppressionDate());
      Printer.print(name + "| " + position + "| " + separationDate);
    }
  }

  private void printHeader() {
    Printer.print("Name                | Position            | Separation Date ");
    Printer.print("------------------------------------------------------------");
  }

  private String format(String input) {
    final int maxLength = 20;
    StringBuilder inputBuilder = new StringBuilder(input);
    while (inputBuilder.length() < maxLength) {
      inputBuilder.append(" ");
    }
    return inputBuilder.toString();
  }
}
