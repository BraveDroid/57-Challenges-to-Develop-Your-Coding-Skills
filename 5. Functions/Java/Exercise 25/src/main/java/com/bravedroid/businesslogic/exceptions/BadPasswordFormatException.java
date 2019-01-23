package com.bravedroid.businesslogic.exceptions;

public class BadPasswordFormatException extends RuntimeException {

  public BadPasswordFormatException(String message) {
    super(message);
  }
}
