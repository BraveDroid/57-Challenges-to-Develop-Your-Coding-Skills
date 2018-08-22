package com.bravedroid.presenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TroubleshootingCarIssuesPrinter {
    private String CarSilent;
    private String batteryCorroded;
    private String carNoise;
    private String carCrankUp;
    private String engineState;
    private String carFuelInjection;

    private BufferedReader input;
    private boolean mustExit;

    public TroubleshootingCarIssuesPrinter() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void printTroubleshootingCarIssues() throws IOException {
        readCarSilent();
        if (CarSilent.equalsIgnoreCase("yes")) {
            readBatteryCorroded();
            if (batteryCorroded.equalsIgnoreCase("yes")) {
                System.out.println("Clean terminals and try starting again.");
                return;
            } else if (batteryCorroded.equalsIgnoreCase("no")) {
                System.out.println("Replace cables and try again.");
                return;
            }
        } else if (CarSilent.equalsIgnoreCase("no")) {
            readCareNoise();
            if (carNoise.equalsIgnoreCase("yes")) {
                System.out.println("Replace the battery");
                return;
            } else if (carNoise.equalsIgnoreCase("no")) {
                readCarCrankUp();
                if (carCrankUp.equalsIgnoreCase("yes")) {
                    System.out.println("Check spark plug connections. ");
                } else if (carCrankUp.equalsIgnoreCase("no")) {
                    readEngineState();
                    if (engineState.equalsIgnoreCase("yes")) {
                        readFuelInjection();
                        if (carFuelInjection.equalsIgnoreCase("no")) {
                            System.out.println("Check to ensure the choke is opening and closing.");
                            return;
                        } else {
                            System.out.println("Get It in for service ");
                        }
                    }
                }
            }
        }
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
                engineState = input.readLine();
                if (this.exitInput(engineState)) {
                    return;
                }
                validateInput(engineState);
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
