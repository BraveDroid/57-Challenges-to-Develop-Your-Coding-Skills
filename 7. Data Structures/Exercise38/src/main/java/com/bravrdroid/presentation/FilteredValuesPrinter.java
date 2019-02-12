package com.bravrdroid.presentation;

import com.bravrdroid.domain.EvenNumberDetector;
import com.bravrdroid.util.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.bravrdroid.util.InputValidator.*;

public class FilteredValuesPrinter {
  private String inputTextFromUser;
  private EvenNumberDetector evenNumberDetector;
  private Logger logger;

  public FilteredValuesPrinter(EvenNumberDetector theEvenNumberDetector, Logger logger) {
    this.evenNumberDetector = theEvenNumberDetector;
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

  public void printEvenNumbers() throws IOException {
    int[] ints = null;
    while (true) {
      String inputStringFromUSer = readInputFromUser();
      try {
        ints = validateInput(inputStringFromUSer);
      } catch (WrongInputException ex) {
        continue;
      }
      break;
    }
    final int[] evenNumbers = evenNumberDetector.filterEvenNumbers(ints);
    System.out.println(concatenateArray(evenNumbers));
  }

  private String readInputFromUser() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter a list of numbers, separated by spaces: ");
    inputTextFromUser = input.readLine();
    return inputTextFromUser;

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
    return password.toString();
  }
}

