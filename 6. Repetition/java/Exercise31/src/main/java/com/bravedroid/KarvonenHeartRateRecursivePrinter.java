package com.bravedroid;

import com.bravedroid.KarvonenHeartRatePrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KarvonenHeartRateRecursivePrinter implements KarvonenHeartRatePrinter {
  private boolean mustExit;
  private String ageFromUser;
  private String heartRateFromUser;
  private BufferedReader input;

  KarvonenHeartRateRecursivePrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  private static void printTableHeader() {
    System.out.println("Intensity     | Rate  ");
    System.out.println("--------------|------- ");
  }

  public void readAge() throws IOException {
    if (mustExit) {
      return;
    }
    System.out.println("Enter your age .");
    ageFromUser = input.readLine();
    if (mustExitMethod(ageFromUser)) {
      mustExit = true;
    } else if (!isNumeric(ageFromUser)) {
      readAge();
    }
  }

  public void readHeartRate() throws IOException {
    if (mustExit) {
      return;
    }
    System.out.println("Enter your resting heart rate.");
    heartRateFromUser = input.readLine();
    if (mustExitMethod(heartRateFromUser)) {
      mustExit = true;
    } else if (!isNumeric(heartRateFromUser)) {
      readHeartRate();
    }
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
