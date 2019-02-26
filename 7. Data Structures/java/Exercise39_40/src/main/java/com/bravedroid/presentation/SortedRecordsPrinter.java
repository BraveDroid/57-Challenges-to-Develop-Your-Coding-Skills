package com.bravedroid.presentation;

import com.bravedroid.data.Records;
import com.bravedroid.domain.Employee;
import com.bravedroid.domain.EmployeeArray;
import com.bravedroid.domain.EmployeeList;
import com.bravedroid.domain.EmployeeMap;
import com.bravedroid.usecases.RecordsSorterLogic;
import com.bravedroid.util.Printer;

import java.util.List;
import java.util.Map;

import static com.bravedroid.data.Records.*;

public class SortedRecordsPrinter {

  private RecordsSorterLogic sorter;
  private List<Employee> employeeList;
  private List<Map<String, String>> employeeListOfMapsOfStrings;
  private List<EmployeeMap> employeeListOfMapsOfEmployeeMap;
  private List<List<String>> employeeListOfListsOfStrings;
  private List<EmployeeList> employeeListOfEmployeeLists;
  private List<String[]> employeeListOfArraysOfString;
  private List<EmployeeArray> employeeListOfArraysOfEmployeeArrays;

  private SortedRecordsPrinter(RecordsSorterLogic sorter) {
    this.sorter = sorter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByEmployeeList(RecordsSorterLogic sorter, List<Employee> employeeList) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeList(employeeList);
    return sortedRecordsPrinter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByMapList(RecordsSorterLogic sorter, List<Map<String, String>> employeeListOfMaps) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeListOfMapsOfStrings(employeeListOfMaps);
    return sortedRecordsPrinter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByListOfMapsOfEmployeeMaps(RecordsSorterLogic sorter, List<EmployeeMap> ListOfMapsOfEmployeeMaps) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeListOfMapsOfEmployeeMaps(ListOfMapsOfEmployeeMaps);
    return sortedRecordsPrinter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByListOfListsOfStrings(RecordsSorterLogic sorter, List<List<String>> ListOfListsOfStrings) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeListOfListsOfStrings(ListOfListsOfStrings);
    return sortedRecordsPrinter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByListOfEmployeeLists(RecordsSorterLogic sorter, List<EmployeeList> ListOfEmployeeLists) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeListOfEmployeeLists(ListOfEmployeeLists);
    return sortedRecordsPrinter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByListOfArraysOfStrings(RecordsSorterLogic sorter, List<String[]> ListOfArraysOfStrings) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeListOfArraysOfStrings(ListOfArraysOfStrings);
    return sortedRecordsPrinter;
  }

  public static SortedRecordsPrinter createSortedRecordsPrinterByListOfArraysOfEmployeeArrays(RecordsSorterLogic sorter, List<EmployeeArray> ListOfArraysOfEmployeeArrays) {
    final SortedRecordsPrinter sortedRecordsPrinter = new SortedRecordsPrinter(sorter);
    sortedRecordsPrinter.setEmployeeListOfArraysOfEmployeeArrays(ListOfArraysOfEmployeeArrays);
    return sortedRecordsPrinter;
  }

  private void setEmployeeList(List<Employee> employeeList) {
    this.employeeList = employeeList;
  }

  private void setEmployeeListOfMapsOfStrings(List<Map<String, String>> employeeListOfMapsOfStrings) {
    this.employeeListOfMapsOfStrings = employeeListOfMapsOfStrings;
  }

  private void setEmployeeListOfMapsOfEmployeeMaps(List<EmployeeMap> employeeListOfMapsOfEmployeeMap) {
    this.employeeListOfMapsOfEmployeeMap = employeeListOfMapsOfEmployeeMap;
  }

  private void setEmployeeListOfListsOfStrings(List<List<String>> employeeListOfListsOfStrings) {
    this.employeeListOfListsOfStrings = employeeListOfListsOfStrings;
  }

  private void setEmployeeListOfEmployeeLists(List<EmployeeList> employeeListOfEmployeeList) {
    this.employeeListOfEmployeeLists = employeeListOfEmployeeList;
  }

  private void setEmployeeListOfArraysOfStrings(List<String[]> employeeListOfArraysOfString) {
    this.employeeListOfArraysOfString = employeeListOfArraysOfString;
  }

  private void setEmployeeListOfArraysOfEmployeeArrays(List<EmployeeArray> employeeListOfArraysOfEmployeeArrays) {
    this.employeeListOfArraysOfEmployeeArrays = employeeListOfArraysOfEmployeeArrays;
  }

  public void printSortedResultListEmployee() {
    printHeader();
    final List<Employee> list = sorter.sortListOfEmployees(employeeList);
    for (Employee item : list) {
      final String name = format(item.getFirstName() + " " + item.getLastName());
      final String position = format(item.getPosition());
      final String separationDate = format(item.getSuppressionDate());
      Printer.print(name + "| " + position + "| " + separationDate);
    }
  }

  public void printSortedResultListMaps() {
    printHeader();
    final List<Map<String, String>> sortListOfMaps = sorter.sortListOfMaps(employeeListOfMapsOfStrings);
    for (Map<String, String> item : sortListOfMaps) {
      final String name = format(item.get(FIRST_NAME_KEY) + " " + item.get(LAST_NAME_KEY));
      final String position = format(item.get(Records.POSITION_KEY));
      final String suppressionDate = format(item.get(Records.SUPPRESSION_DATE_KEY));
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  public void printSortedResultListEmployeeMap() {
    printHeader();
    final List<EmployeeMap> sortListOfEmployeeMap = sorter.sortListOfEmployeeMap(employeeListOfMapsOfEmployeeMap);
    for (EmployeeMap item : sortListOfEmployeeMap) {
      final String name = format(item.getFirstName() + " " + item.getLastName());
      final String position = format(item.getPosition());
      final String suppressionDate = format(item.getSuppressionDate());
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  public void printSortedResultListOfString() {
    printHeader();
    final List<List<String>> sortListOfListsOfStrings = sorter.sortListOfString(employeeListOfListsOfStrings);
    for (List<String> item : sortListOfListsOfStrings) {
      final String name = format(item.get(0) + " " + item.get(1));
      final String position = format(item.get(2));
      final String suppressionDate = format(item.get(3));
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  public void printSortedResultListOfEmployeeList() {
    printHeader();
    final List<EmployeeList> sortedListOfEmployeeList = sorter.sortListOfEmployeeList(employeeListOfEmployeeLists);
    for (EmployeeList item : sortedListOfEmployeeList) {
      final String name = format(item.getFirstName() + " " + item.getLastName());
      final String position = format(item.getPosition());
      final String suppressionDate = format(item.getSuppressionDate());
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  public void printSortedResultListOfArrayOfStrings() {
    printHeader();
    final List<String[]> sortListOfMaps = sorter.sortListOfArray(employeeListOfArraysOfString);
    for (String[] item : sortListOfMaps) {
      final String name = format(item[0] + " " + item[1]);
      final String position = format(item[2]);
      final String suppressionDate = format(item[3]);
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  public void printSortedResultListOfEmployeeArray() {
    printHeader();
    final List<EmployeeArray> sortListOfMaps = sorter.sortListOfEmployeeArrayList(employeeListOfArraysOfEmployeeArrays);
    for (EmployeeArray item : sortListOfMaps) {
      final String name = format(item.getFirstName() + " " + item.getLastName());
      final String position = format(item.getPosition());
      final String suppressionDate = format(item.getSuppressionDate());
      Printer.print(name + "| " + position + "| " + suppressionDate);
    }
  }

  private void printHeader() {
    Printer.print("------------------------------------------------------------");
    Printer.print("Name                | Position            | Separation Date ");
    Printer.print("------------------------------------------------------------");
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
