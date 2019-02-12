package com.bravrdroid.util;

public class Logger {
  private boolean isDebug;

  public Logger(boolean isDebug) {
    this.isDebug = isDebug;
  }

  public void log(Object msg) {
    if (isDebug) {
      System.out.println("*******" + msg + "*******");
    }
  }
}

