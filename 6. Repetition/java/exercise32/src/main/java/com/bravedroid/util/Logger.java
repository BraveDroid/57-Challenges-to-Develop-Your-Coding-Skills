package com.bravedroid.util;

public class Logger {
  private static boolean isDebug;

  public Logger(boolean isDebug) {
    Logger.isDebug = isDebug;
  }

  public void log(Object msg) {
    if (isDebug) {
      System.out.println(msg);
    }
  }
}
