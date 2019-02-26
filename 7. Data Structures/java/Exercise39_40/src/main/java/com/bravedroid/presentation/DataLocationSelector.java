package com.bravedroid.presentation;

import com.bravedroid.data.CmdConsoleRepository;
import com.bravedroid.data.FileRepositoryImpl;
import com.bravedroid.data.Records;
import com.bravedroid.data.Repository;
import com.bravedroid.usecases.RecordsSearcherLogic;
import com.bravedroid.usecases.RecordsSorterLogic;
import com.bravedroid.util.Printer;
import com.bravedroid.util.ValidateInput.*;

import java.io.IOException;

import static com.bravedroid.util.ValidateInput.*;

public class DataLocationSelector {
  final static int SORT = 1;
  final static int SEARCH = 2;

  private final static int FILE_INPUT_TYPE = 1;
  private final static int MEMORY_INPUT_TYPE = 2;
  private final static int CONSOLE_INPUT_TYPE = 3;

  private ReaderCmd reader;
  private RecordsSearcherLogic searcher;
  private RecordsSorterLogic sorter;

  DataLocationSelector(ReaderCmd reader, RecordsSorterLogic sorter) {
    this.reader = reader;
    this.sorter = sorter;
  }

  DataLocationSelector(ReaderCmd reader, RecordsSearcherLogic searcher) {
    this.reader = reader;
    this.searcher = searcher;
  }

  public void promptForDataLocation(int type) throws IOException {
    int parseInput = 0;
    while ((parseInput < FILE_INPUT_TYPE) || (parseInput > CONSOLE_INPUT_TYPE)) {
      final String inputFromUser = reader.readInput("Enter Data Location " + '\n' +
              "1 : read data from file " + '\n' +
              "2 : read data from data Structure  " + '\n' +
              "3 : read data from cmd ");
      try {
        parseInput = validateInput(inputFromUser);
      } catch (IllegalArgumentException ignored) {
        Printer.print("Invalid Input");
      }
      switch (parseInput) {
        case FILE_INPUT_TYPE:
          if (type == SORT) {
            sortRecordsFromFile();
            break;
          }
          if (type == SEARCH) {
            searchRecordsFromFile();
            break;
          }
          break;
        case MEMORY_INPUT_TYPE:
          if (type == SORT) {
            sortRecordsFromMemory();
            break;
          }
          if (type == SEARCH) {
            searchRecordsFromMemory();
            break;
          }
          break;
        case CONSOLE_INPUT_TYPE:
          if (type == SORT) {
            sortRecordsFromConsole();
            break;
          }
          if (type == SEARCH) {
            searchRecordsFromConsole();
            break;
          }
          break;
      }
    }
  }

  private void searchRecordsFromConsole() {
    Repository repositoryCmd = new CmdConsoleRepository(new ReaderCmd());
    try {
      SearchedRecordsPrinter searchedRecordsPrinterFromCmd = SearchedRecordsPrinter.createSearchedRecordsPrinterWithReaderCmd(reader, searcher, repositoryCmd.getRecords());
      searchedRecordsPrinterFromCmd.printSearchedResultListEmployee();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("CAN NOT FIND THE FILE_INPUT_TYPE!!!");
    }
  }

  private void sortRecordsFromConsole() {
    Repository repositoryCmd = new CmdConsoleRepository(new ReaderCmd());
    try {
      SortedRecordsPrinter sortedRecordsFromCmd = SortedRecordsPrinter.createSortedRecordsPrinterByEmployeeList(sorter, repositoryCmd.getRecords());
      sortedRecordsFromCmd.printSortedResultListEmployee();
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("CAN NOT FIND THE FILE_INPUT_TYPE!!!");
    }
  }

  private void searchRecordsFromMemory() throws IOException {
    SearchedRecordsPrinter searchedRecordsPrinterFromDataStructure = SearchedRecordsPrinter.createSearchedRecordsPrinter(searcher, Records.ALL_1);
    searchedRecordsPrinterFromDataStructure.printSearchedResultListEmployee();
  }

  private void sortRecordsFromMemory() {
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

  private void searchRecordsFromFile() throws IOException {
    Repository repositoryFile = new FileRepositoryImpl();
    final SearchedRecordsPrinter searchedRecordsPrinterFromFile = SearchedRecordsPrinter.createSearchedRecordsPrinter(searcher, repositoryFile.getRecords());
    searchedRecordsPrinterFromFile.printSearchedResultListEmployee();
  }

  private void sortRecordsFromFile() throws IOException {
    Repository repository = new FileRepositoryImpl();
    SortedRecordsPrinter sortedRecordsFromFile = SortedRecordsPrinter.createSortedRecordsPrinterByEmployeeList(sorter, repository.getRecords());
    sortedRecordsFromFile.printSortedResultListEmployee();
  }

  private int validateInput(String inputFromUser) {
    if (mustExitMethod(inputFromUser)) {
      throw new MustExitException();
    }
    if (isBlank(inputFromUser) || isNegativeOrZero(inputFromUser) || !isNumeric(inputFromUser)) {
      throw new WrongInputException();
    }
    if (isValidChoice(inputFromUser)) {
      throw new WrongInputException();
    } else {
      return Integer.parseInt(inputFromUser);
    }
  }

  private boolean isValidChoice(String inputFromUser) {
    final int parseInt = Integer.parseInt(inputFromUser);
    return parseInt > 3 || parseInt == 0;
  }
}
