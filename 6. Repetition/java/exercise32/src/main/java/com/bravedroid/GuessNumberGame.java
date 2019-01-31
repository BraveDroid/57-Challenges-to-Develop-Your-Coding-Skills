package com.bravedroid;

import com.bravedroid.util.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class GuessNumberGame {
  private static final int LEVEL_ONE = 1;
  private static final int LEVEL_TWO = 2;
  private static final int LEVEL_THREE = 3;
  private static final int MAX_TRIES = 7;

  private final Printer printer;
  private final Logger logger;

  private BufferedReader input;

  GuessNumberGame(Printer printer, Logger logger) {
    this.printer = printer;
    this.logger = logger;
    input = new BufferedReader(new InputStreamReader(System.in));
  }


  public void start() throws IOException, MustExitException {
    final int difficultyLevel = requestDifficultyLevel();

    final int correctGuessNumber = defineGoodGuessNumber(difficultyLevel);
    logger.log("******* the correctGuessNumber is " + correctGuessNumber);
    printer.print("I have my number. What's your guess?");

    for (int guessesCount = 0; guessesCount < MAX_TRIES; ++guessesCount) {
      logger.log("******* the guessesCount is " + guessesCount);
      printer.print("GuessesCount is  " + guessesCount);
      String userInput = input.readLine();

      if (!isNumeric(userInput)) {
        if (mustExitMethod(userInput)) {
          throw new MustExitException();
        }
        printer.print("Input is invalid, Guess Again !");
      } else {
        int userGuessNumber = Integer.parseInt(userInput);
        if (userGuessNumber > correctGuessNumber) {
          printer.print("Too low.  Guess again: ");
        } else if (userGuessNumber < correctGuessNumber) {
          printer.print("Too high.  Guess again: ");
        } else {
          printer.print("You got it in " + guessesCount + " guesses :)!");
          break;
        }
      }
      if (guessesCount == MAX_TRIES - 1) {
        logger.log("******* guessesCount == MAX_TRIES " + guessesCount);
        printer.print("You didn't got it, may be next time :(");
      }
    }
    requestForPlayingAgain();
  }

  private int defineGoodGuessNumber(int level) {
    Random rand = new Random();
    switch (level) {
      case LEVEL_ONE:
        return rand.nextInt(10) + 1;
      case LEVEL_TWO:
        return rand.nextInt(100) + 1;
      case LEVEL_THREE:
        return rand.nextInt(1000) + 1;
      default:
        throw new IllegalArgumentException("Number must be only 1,2 or 3!!");
    }
  }

  private int requestDifficultyLevel() throws IOException {
    printer.print("Let's play Guess the Number.");
    while (true) {
      printer.print("Pick a difficulty level (1, 2, or 3):");
      String difficultyLevelInput = input.readLine();
      if (!isNumeric(difficultyLevelInput)) {
        if (mustExitMethod(difficultyLevelInput)) {
          throw new MustExitException();
        }
        printer.print("Wrong input detected");
      } else {
        int difficultyLevel = Integer.parseInt(difficultyLevelInput);
        if (difficultyLevel < LEVEL_ONE || difficultyLevel > LEVEL_THREE) {
          printer.print("input must be 1 or 2 or 3");
        } else {
          return difficultyLevel;
        }
      }
    }
  }

  private void requestForPlayingAgain() throws IOException {
    while (true) {
      printer.print("Play Again ?");
      String anotherGame = input.readLine();
      if (mustExitMethod(anotherGame)) {
        throw new MustExitException();
      }
      if (anotherGame.equals("n")) {
        printer.print("Goodbye !");
        break;
      }
      if (anotherGame.equals("y")) {
        start();
        break;
      }
      printer.print("Unknown Input !!");
    }
  }

  private boolean isNumeric(String input) {
    boolean isNumeric = true;
    try {
      Integer.parseInt(input);
    } catch (IllegalArgumentException ex) {
      isNumeric = false;
    }
    return isNumeric;
  }

  private boolean mustExitMethod(String input) {
    return input.equals("exit");
  }

  static class MustExitException extends RuntimeException {
    MustExitException() {
      super("user requested exit exception");
    }
  }
}
