package com.bravedroid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KarvonenHeartRateInfiniteLoopPrinter implements KarvonenHeartRatePrinter {
  private boolean mustExit;
  private String ageFromUser;
  private String heartRateFromUser;
  private BufferedReader input;

  KarvonenHeartRateInfiniteLoopPrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  private static void printTableHeader() {
    System.out.println("Intensity     | Rate  ");
    System.out.println("--------------|------- ");
  }

  public void readAge() throws IOException {
    while (true) {
      promptForAge();
      if (mustExitMethod(ageFromUser)) {
        mustExit = true;
        return;
      }
      if (isNumeric(ageFromUser) | mustExit) {
        break;
      }
    }
  }

  public void readHeartRate() throws IOException {
    if (mustExit) {
      return;
    }
    while (true) {
      promptHeartRate();
      if (mustExitMethod(heartRateFromUser)) {
        mustExit = true;
        return;
      }
      if (isNumeric(heartRateFromUser) | mustExit) {
        break;
      }
    }
  }

  private void promptForAge() throws IOException {
    System.out.println("Enter your age .");
    ageFromUser = input.readLine();
  }

  private void promptHeartRate() throws IOException {
    System.out.println("Enter your resting heart rate.");
    heartRateFromUser = input.readLine();
  }

  public void printHeartRate() {
    if (mustExit) {
      return;
    }
    printTableHeader();
    printTableBody();
  }

  private void printTableBody() {
    int age = Integer.parseInt(ageFromUser);
    int heartRate = Integer.parseInt(heartRateFromUser);
    for (int intensity = 55; intensity <= 95; intensity += 5) {
      float intensityPercentage = (float) intensity / 100;
      //formula target heart rate
      int targetHeartRate = (int) ((((220 - age) - heartRate) * intensityPercentage) + heartRate);
      System.out.println(intensity + " % " + "         | " + targetHeartRate + " bpm");
    }
  }

  private boolean isNumeric(String input) {
    boolean isNumeric = true;
    try {
      Integer.parseInt(input);
    } catch (IllegalArgumentException ex) {
      isNumeric = false;
      System.out.println("Input is not in numeric format ");
    }
    return isNumeric;
  }

  private boolean mustExitMethod(String input) {
    mustExit = input.equals("exit");
    return mustExit;
  }
}
