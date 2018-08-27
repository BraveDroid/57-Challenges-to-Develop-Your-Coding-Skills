package com.bravedroid.businesslogic;

public class AnagramChecker {
  public boolean isAnagram(String firstString, String secondString) {
    if (!hasSameInput(firstString, secondString)) {
      return false;
    }
    final char[] firstStringArray = firstString.toCharArray();
    final char[] secondStringArray = secondString.toCharArray();

    for (char c : firstStringArray) {
      if (!containsLetter(secondStringArray, c)) {
        return false;
      }
    }
    for (char c : secondStringArray) {
      if (!containsLetter(firstStringArray, c)) {
        return false;
      }
    }
    return true;
  }

  private boolean hasSameInput(String firstString, String secondString) {
    if (firstString.length() != secondString.length()) return false;
    return true;
  }

  private boolean containsLetter(char[] array, char letter) {
    for (char c : array) {
      if (letter == c) {
        return true;
      }
    }
    return false;
  }
}
