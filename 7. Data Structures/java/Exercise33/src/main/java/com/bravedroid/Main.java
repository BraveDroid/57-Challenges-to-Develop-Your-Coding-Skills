package com.bravedroid;

import com.bravedroid.util.Printer;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Magic8BallGame magic8BallGame = new Magic8BallGame();
   try{ magic8BallGame.promptForQuestion();
  }catch (Magic8BallGame.MustExitException ignored){
     Printer.print("BYE BYE :)");
   }
  }
}
