package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TroubleshootingCarIssuesPrinter {
  private String CarSilent;
  private String batteryCorroded;
  private String carNoise;
  private String carCrankUp;
  private String engineStartAndDie;
  private String carFuelInjection;

  private BufferedReader input;
  private boolean mustExit;

  public TroubleshootingCarIssuesPrinter() {
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  public void printTroubleshootingCarIssues() throws IOException {
    readCarSilent();
    final boolean isCarSilent = CarSilent.equalsIgnoreCase("yes");
    if (isCarSilent) {
      readBatteryCorroded();
      final boolean isBatteryCorroded = batteryCorroded.equalsIgnoreCase("yes");
      treatBatteryCorroded(isBatteryCorroded);
    } else {
      readCareNoise();
      final boolean hasNoise = carNoise.equalsIgnoreCase("yes");
      treatCarHasNoise(hasNoise);
    }
  }

  private void treatBatteryCorroded(boolean isBatteryCorroded) {
    if (isBatteryCorroded) {
      System.out.println("Clean terminals and try starting again.");
    } else {
      System.out.println("Replace cables and try again.");
    }
  }

  private void treatCarHasNoise(boolean hasNoise) throws IOException {
    if (hasNoise) {
      System.out.println("Replace the battery");
    } else {
      readCarCrankUp();
      final boolean isCarCrankUp = carCrankUp.equalsIgnoreCase("yes");
      treatCarCrankUp(isCarCrankUp);
    }
  }

  private void treatCarCrankUp(boolean isCarCrankUp) throws IOException {
    if (isCarCrankUp) {
      System.out.println("Check spark plug connections. ");
    } else {
      readEngineState();
      final boolean doesEngineStartAndDie = engineStartAndDie.equalsIgnoreCase("yes");
      if (doesEngineStartAndDie) {
        readFuelInjection();
        final boolean hasFuelInjection = carFuelInjection.equalsIgnoreCase("yes");
        treatFuelInject(hasFuelInjection);
      }
    }
  }

  private void treatFuelInject(boolean hasFuelInjection) {
    if (hasFuelInjection) {
      System.out.println("Get It in for service ");
      return;
    }
    System.out.println("Check to ensure the choke is opening and closing.");
  }

  private void readCarSilent() throws IOException {
    if (!this.mustExit) {
      System.out.println("Is the car silent when you turn the key ? ");
      try {
        CarSilent = input.readLine();
        if (this.exitInput(CarSilent)) {
          return;
        }
        validateInput(CarSilent);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readCarSilent();
      }
    }
  }

  private void readBatteryCorroded() throws IOException {
    if (!this.mustExit) {
      System.out.println("Are the battery terminals corroded ?");
      try {
        batteryCorroded = input.readLine();
        if (this.exitInput(batteryCorroded)) {
          return;
        }
        validateInput(batteryCorroded);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readBatteryCorroded();
      }
    }
  }

  private void readCareNoise() throws IOException {
    if (!this.mustExit) {
      System.out.println("Does the car make a clicking noise ? ");
      try {
        carNoise = input.readLine();
        if (this.exitInput(carNoise)) {
          return;
        }
        validateInput(carNoise);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readCareNoise();
      }
    }
  }

  private void readCarCrankUp() throws IOException {
    if (!this.mustExit) {
      System.out.println("Does the car crank up but fail to start ? ");
      try {
        carCrankUp = input.readLine();
        if (this.exitInput(carCrankUp)) {
          return;
        }
        validateInput(carCrankUp);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readCarCrankUp();
      }
    }
  }

  private void readEngineState() throws IOException {
    if (!this.mustExit) {
      System.out.println("Does the engine start and then die ? ");
      try {
        engineStartAndDie = input.readLine();
        if (this.exitInput(engineStartAndDie)) {
          return;
        }
        validateInput(engineStartAndDie);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readEngineState();
      }
    }
  }

  private void readFuelInjection() throws IOException {
    if (!this.mustExit) {
      System.out.println("Does your car have fuel injection ? ");
      try {
        carFuelInjection = input.readLine();
        if (this.exitInput(carFuelInjection)) {
          return;
        }
        validateInput(carFuelInjection);
      } catch (IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        readFuelInjection();
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
    if (!inputFromUser.equalsIgnoreCase("yes") && !inputFromUser.equalsIgnoreCase("no")) {
      throw new IllegalArgumentException("Input value should be Yes or No !! ");
    }
  }
}
