package com.bravedroid;

import com.bravedroid.data.Records;
import com.bravedroid.domain.Employee;
import com.bravedroid.presentation.SortedRecordsPrinter;
import com.bravedroid.usecases.RecordsSorterLogic;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    final List<Employee> employeeList = Records.ALL;
    RecordsSorterLogic sorter = new RecordsSorterLogic();
    SortedRecordsPrinter printerSortedRecords = new SortedRecordsPrinter(sorter, employeeList);
    printerSortedRecords.printSortedResult();
  }
}
