package com.bravedroid.util;

public class ValidateInput {

  public static boolean isNegativeOrZero(String input) {
    int num = Integer.parseInt(input);
    return num <= 0;
  }

  public static boolean isNumeric(String input) {
    boolean isNumeric = true;
    try {
      Long.parseLong(input);
    } catch (IllegalArgumentException ex) {
      isNumeric = false;
    }
    return isNumeric;
  }

  public static boolean isBlank(String value) {
    return value.trim().equals("");
  }

  public static boolean mustExitMethod(String input) {
    return input.equals("exit");
  }

  public static class MustExitException extends RuntimeException {
    public MustExitException() {
      super("user requested exit exception");
    }
  }
  public static class WrongInputException extends IllegalArgumentException {
    public WrongInputException() {
      super("Bad inputs exception");
    }
  }
}
