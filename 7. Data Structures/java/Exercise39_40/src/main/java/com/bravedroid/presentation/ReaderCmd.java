package com.bravedroid.presentation;

import com.bravedroid.util.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderCmd {
  public String readInput(String msgToPrompt) throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    Printer.print(msgToPrompt);
    return input.readLine();
  }
}
