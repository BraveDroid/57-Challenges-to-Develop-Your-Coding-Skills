package com.bravedroid.presentation;

import com.bravedroid.domain.Employee;
import com.bravedroid.usecases.RecordsSearcherLogic;
import com.bravedroid.util.Printer;

import java.io.IOException;
import java.util.List;

import static com.bravedroid.util.ValidateInput.*;

public class SearchedRecordsPrinter {
  private List<Employee> employeeList;
  private ReaderCmd readerCmd;
  private RecordsSearcherLogic searcher;

  private SearchedRecordsPrinter(RecordsSearcherLogic searcher) {
    this.searcher = searcher;
  }

  private SearchedRecordsPrinter(ReaderCmd readerCmd, RecordsSearcherLogic searcher) {
    this.searcher = searcher;
    this.readerCmd = readerCmd;
  }

  public static SearchedRecordsPrinter createSearchedRecordsPrinterWithReaderCmd(ReaderCmd readerCmd, RecordsSearcherLogic searcher, List<Employee> employeeList) {
    SearchedRecordsPrinter searchedRecordsPrinter = new SearchedRecordsPrinter(readerCmd, searcher);
    searchedRecordsPrinter.setEmployeeList(employeeList);
    return searchedRecordsPrinter;
  }

  public static SearchedRecordsPrinter createSearchedRecordsPrinter(RecordsSearcherLogic searcher, List<Employee> employeeList) {
    SearchedRecordsPrinter searchedRecordsPrinter = new SearchedRecordsPrinter(searcher);
    searchedRecordsPrinter.setEmployeeList(employeeList);
    return searchedRecordsPrinter;
  }

  private void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  public void printSearchedResultListEmployee() throws IOException {
    String searchString = promptForSearchString();
    final List<Employee> searchResultList = searcher.search(searchString, employeeList);
    printHeader();
    for (Employee item : searchResultList) {
      final String name = format(item.getFirstName() + " " + item.getLastName());
      final String position = format(item.getPosition());
      final String suppressionDate = format(item.getSuppressionDate());
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  private String promptForSearchString() throws IOException {
    String inputFromInput;
    while (true) {
      inputFromInput = readerCmd.readInput("Enter a search string");
      try {
        if (validateInput(inputFromInput)) {
          return inputFromInput;
        }
      } catch (IllegalArgumentException ex) {
        Printer.print("Invalid Input !!");
      }
    }
  }

  private void printHeader() {
    Printer.print("------------------------------------------------------------");
    Printer.print("Name                | Position            | Separation Date ");
    Printer.print("------------------------------------------------------------");
  }

  private boolean validateInput(String inputFromUser) {
    if (mustExitMethod(inputFromUser)) {
      throw new MustExitException();
    }
    if (isBlank(inputFromUser) || isNumeric(inputFromUser)) {
      throw new WrongInputException();
    }
    return true;
  }

  private String format(Object input) {
    final int maxLength = 20;
    StringBuilder inputBuilder = new StringBuilder((String) input);
    while (inputBuilder.length() < maxLength) {
      inputBuilder.append(" ");
    }
    return inputBuilder.toString();
  }
}
