package com.bravedroid;

import com.bravedroid.util.Logger;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    boolean isDebug = false;
    PickingAWinner pickingAWinner = new PickingAWinner(new Logger(isDebug));
    try {
      pickingAWinner.promptWinnerName();
    } catch (PickingAWinner.MustExitException ignored) {
      System.out.println("BYE BYE :)");
    }
  }
}
