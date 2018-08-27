package com.bravedroid.presenter;

import com.bravedroid.businesslogic.AnagramChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AnagramCheckerPrinter {
  private static final String REQUEST_MESSAGE_FIRST_STRING = "Enter the first string: ";
  private static final String REQUEST_MESSAGE_SECOND_STRING = "Enter the second string: ";

  private boolean mustExit;
  private AnagramChecker anagramChecker;
  private BufferedReader input;
  private String firstString;
  private String secondString;

  public AnagramCheckerPrinter(AnagramChecker anagramChecker) {
    this.anagramChecker = anagramChecker;
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  public void printFirstStatement() {
    System.out.println("Enter two strings and I'll tell you if they " + "\n" +
            "are anagrams:");
  }

  public void readFirstString() throws IOException {
    if (!mustExit) {
      System.out.println(REQUEST_MESSAGE_FIRST_STRING);
      try {
        firstString = input.readLine();
        if (this.exitInput(firstString)) {
          return;
        }
        validateInput(firstString);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readFirstString();
      }
    }
  }

  public void readSecondString() throws IOException {
    if (!mustExit) {
      System.out.println(REQUEST_MESSAGE_SECOND_STRING);
      try {
        secondString = input.readLine();
        if (this.exitInput(secondString)) {
          return;
        }
        validateInput(secondString);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readSecondString();
      }
    }
  }

  public void printAnagramChecker() {
    if (!mustExit) {
      boolean isAnagram = anagramChecker.isAnagram(firstString, secondString);
      if (isAnagram) {
        System.out.println("\"" + firstString + "\"" + " and " + "\"" + secondString + "\"" + " are anagrams.");
      } else {
        System.out.println("\"" + firstString + "\"" + " and " + "\"" + secondString + "\"" + " are not anagrams.");
      }
    }
  }

  private boolean exitInput(String inputFromUse) {
    if (inputFromUse.equalsIgnoreCase("exit")) {
      this.mustExit = true;
    }
    return this.mustExit;
  }

  private void validateInput(String inputFromUser) {
    if (inputFromUser.equalsIgnoreCase("") || inputFromUser.equalsIgnoreCase("")) {
      throw new IllegalArgumentException("Input value should be a string not void !! ");
    }
  }
}
