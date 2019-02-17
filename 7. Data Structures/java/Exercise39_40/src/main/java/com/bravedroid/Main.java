package com.bravedroid;

import com.bravedroid.data.CmdConsoleRepository;
import com.bravedroid.data.Records;
import com.bravedroid.data.Repository;
import com.bravedroid.data.FileRepositoryImpl;
import com.bravedroid.presentation.ReaderCmd;
import com.bravedroid.presentation.SortedRecordsPrinter;
import com.bravedroid.usecases.RecordsSorterLogic;
import com.bravedroid.util.Printer;
import com.bravedroid.util.ValidateInput;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    RecordsSorterLogic sorter = new RecordsSorterLogic();
    //Repository repository = new FileRepositoryImpl();
    Repository repository = new CmdConsoleRepository(new ReaderCmd());
    try {
      SortedRecordsPrinter sortedRecords = SortedRecordsPrinter.createSortedRecordsPrinterByEmployeeList(sorter, repository.getRecords());
      sortedRecords.printSortedResultListEmployee();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("CAN NOT FIND THE FILE!!!");
    } catch (ValidateInput.MustExitException ignored) {
      Printer.print("GOOD BYE :)");
    }

    SortedRecordsPrinter sortedRecordsPrinter = SortedRecordsPrinter.createSortedRecordsPrinterByEmployeeList(sorter, Records.ALL_1);
    sortedRecordsPrinter.printSortedResultListEmployee();

    SortedRecordsPrinter sortedRecordsOfListMapPrinter = SortedRecordsPrinter.createSortedRecordsPrinterByMapList(sorter, Records.ALL_2);
    sortedRecordsOfListMapPrinter.printSortedResultListMaps();

    SortedRecordsPrinter sortedListOfMapsOfEmployeeMaps = SortedRecordsPrinter.createSortedRecordsPrinterByListOfMapsOfEmployeeMaps(sorter, Records.ALL_3);
    sortedListOfMapsOfEmployeeMaps.printSortedResultListEmployeeMap();

    SortedRecordsPrinter sortedRecordsPrinterByListOfEmployeeLists = SortedRecordsPrinter.createSortedRecordsPrinterByListOfEmployeeLists(sorter, Records.ALL_4);
    sortedRecordsPrinterByListOfEmployeeLists.printSortedResultListOfEmployeeList();

    SortedRecordsPrinter sortedRecordsPrinterByListOfListsOfStrings = SortedRecordsPrinter.createSortedRecordsPrinterByListOfListsOfStrings(sorter, Records.ALL_5);
    sortedRecordsPrinterByListOfListsOfStrings.printSortedResultListOfString();

    SortedRecordsPrinter sortedRecordsPrinterByListOfArraysOfStrings = SortedRecordsPrinter.createSortedRecordsPrinterByListOfArraysOfStrings(sorter, Records.ALL_6);
    sortedRecordsPrinterByListOfArraysOfStrings.printSortedResultListOfArrayOfStrings();

    SortedRecordsPrinter sortedRecordsPrinterByListOfArraysOfEmployeeArrays = SortedRecordsPrinter.createSortedRecordsPrinterByListOfArraysOfEmployeeArrays(sorter, Records.ALL_7);
    sortedRecordsPrinterByListOfArraysOfEmployeeArrays.printSortedResultListOfEmployeeArray();
  }
}
