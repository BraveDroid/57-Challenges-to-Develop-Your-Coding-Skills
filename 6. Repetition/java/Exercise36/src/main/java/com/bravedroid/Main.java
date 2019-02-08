package com.bravedroid;

import com.bravedroid.presentation.StandardDeviationPrinter;
import com.bravedroid.util.Logger;

import java.io.IOException;

//https://www.wikihow.com/Calculate-Standard-Deviation
public class Main {
  private static boolean isDebug = false;

  public static void main(String[] args) throws IOException {
    StandardDeviationPrinter standardDeviationPrinter = new StandardDeviationPrinter(new Logger(isDebug));
    try {
      standardDeviationPrinter.printStandardDeviation();
    } catch (StandardDeviationPrinter.MustExitException ignored) {
      System.out.println("BYE BYE :)");
    }
  }
}

