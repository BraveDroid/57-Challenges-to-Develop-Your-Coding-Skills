package com.bravedroid;

import com.bravedroid.businesslogic.AnagramChecker;
import com.bravedroid.presenter.AnagramCheckerPrinter;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    AnagramChecker anagramChecker = new AnagramChecker();
    AnagramCheckerPrinter anagramCheckerPrinter = new AnagramCheckerPrinter(anagramChecker);
    anagramCheckerPrinter.printFirstStatement();
    anagramCheckerPrinter.readFirstString();
    anagramCheckerPrinter.readSecondString();
    anagramCheckerPrinter.printAnagramChecker();
  }
}
