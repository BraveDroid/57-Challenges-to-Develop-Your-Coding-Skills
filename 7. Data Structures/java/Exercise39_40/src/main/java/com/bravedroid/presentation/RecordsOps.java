package com.bravedroid.presentation;

import com.bravedroid.usecases.RecordsSearcherLogic;
import com.bravedroid.usecases.RecordsSorterLogic;
import com.bravedroid.util.Printer;
import com.bravedroid.util.ValidateInput;

import java.io.IOException;

import static com.bravedroid.presentation.DataLocationSelector.*;
import static com.bravedroid.util.ValidateInput.*;

public class RecordsOps {
  private ReaderCmd reader;

  public RecordsOps(ReaderCmd reader) {
    this.reader = reader;
  }

  public void promptForOperation() throws IOException {
    int parseInput = 0;
    while ((parseInput < 1) || (parseInput > 2)) {
      final String inputFromUser = reader.readInput("Enter Operation Number " + '\n' +
              "1 : Sorting Records Program " + '\n' +
              "2 : Searching Records Program  ");
      try {
        parseInput = validateInput(inputFromUser);
      } catch (IllegalArgumentException ignored) {
        Printer.print("Invalid Input");
      }
      switch (parseInput) {
        case 1:
          RecordsSorterLogic sorter = new RecordsSorterLogic();
          DataLocationSelector dataLocationSelector1 = new DataLocationSelector(reader, sorter);
          dataLocationSelector1.promptForDataLocation(SORT);
          break;
        case 2:
          RecordsSearcherLogic searcherLogic = new RecordsSearcherLogic();
          DataLocationSelector dataLocationSelector2 = new DataLocationSelector(reader, searcherLogic);
          dataLocationSelector2.promptForDataLocation(SEARCH);
          break;
        default:
          break;
      }
    }
  }

  private int validateInput(String inputFromUser) {
    if (mustExitMethod(inputFromUser)) {
      throw new ValidateInput.MustExitException();
    }
    if (isBlank(inputFromUser) || isNegativeOrZero(inputFromUser) || !isNumeric(inputFromUser)) {
      throw new WrongInputException();
    }
    if (isValidChoice(inputFromUser)) {
      throw new WrongInputException();
    }
    return Integer.parseInt(inputFromUser);
  }

  private boolean isValidChoice(String inputFromUser) {
    final int parseInt = Integer.parseInt(inputFromUser);
    return parseInt > 2 || parseInt == 0;
  }
}
