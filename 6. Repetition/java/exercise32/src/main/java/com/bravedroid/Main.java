package com.bravedroid;

import com.bravedroid.util.Logger;

import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    boolean isDebug = false;
    GuessNumberGame guessNumberGame = new GuessNumberGame(new Printer(), new Logger(isDebug));
    try {
      guessNumberGame.start();
    } catch (GuessNumberGame.MustExitException | IOException ignored) {
    }
  }
}
