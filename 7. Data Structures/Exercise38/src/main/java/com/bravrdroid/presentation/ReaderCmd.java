package com.bravrdroid.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderCmd {
  public String read() throws IOException {
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter a list of numbers, separated by spaces: ");
    return input.readLine();
  }
}

