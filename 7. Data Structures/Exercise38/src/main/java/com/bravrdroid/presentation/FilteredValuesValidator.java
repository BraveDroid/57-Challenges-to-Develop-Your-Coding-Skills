package com.bravrdroid.presentation;

import com.bravrdroid.domain.EvenNumberFilter;
import com.bravrdroid.util.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.bravrdroid.util.InputValidator.*;

public class FilteredValuesValidator {
  private final ReaderCmd reader;
  private final EvenNumberFilter evenNumberFilter;
  private final Logger logger;

  public FilteredValuesValidator(ReaderCmd reader, EvenNumberFilter evenNumberFilter, Logger logger) {
    this.reader = reader;
    this.evenNumberFilter = evenNumberFilter;
    this.logger = logger;
  }

  private static boolean isNotAllNumeric(String input) {
    String[] split = input.split(" ");
    for (String item : split) {
      if (!isBlank(item)) {
        try {
          Integer.parseInt(item);
        } catch (IllegalArgumentException ex) {
          return true;
        }
      }
    }
    return false;
  }

  public String printEvenNumbers() throws IOException {
    int[] ints;
    while (true) {
      String inputStringFromUSer = reader.read();
      try {
        ints = validateInput(inputStringFromUSer);
      } catch (WrongInputException ex) {
        continue;
      }
      break;
    }
    final int[] evenNumbers = evenNumberFilter.filterEvenNumbers(ints);
    return concatenateArray(evenNumbers);
  }


  /*package*/ int[] validateInput(String inputFromUser) {
    if (mustExitMethod(inputFromUser)) throw new MustExitException();
    if (isBlank(inputFromUser) || (isNotAllNumeric(inputFromUser))) throw new WrongInputException();
    return extractInts(inputFromUser);
  }

  private int[] extractInts(String inputFromUser) {
    List<Integer> resultList = new ArrayList<>();
    String[] split = inputFromUser.split(" ");
    for (String item : split) {
      if (!isBlank(item)) {
        logger.log(item);
        int i = Integer.parseInt(item.trim());
        resultList.add(i);
      }
    }
    logger.log("The Size is ! " + resultList.size());
    return fromListToArray(resultList);
  }

  private int[] fromListToArray(List<Integer> resultList) {
    final int[] ints = new int[resultList.size()];
    int i = 0;
    for (Integer item : resultList) {
      ints[i++] = item;
    }
    return ints;
  }

  private String concatenateArray(int[] passwordInCharsArray) {
    StringBuilder password = new StringBuilder();
    for (int item : passwordInCharsArray) {
      password.append(String.valueOf(item)).append(" ");
    }
    return password.toString().trim();
  }

}

