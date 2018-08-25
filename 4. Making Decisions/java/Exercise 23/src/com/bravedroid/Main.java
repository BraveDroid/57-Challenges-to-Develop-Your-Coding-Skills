package com.bravedroid;

import com.bravedroid.presenter.TroubleshootingCarIssuesPrinter;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {
    TroubleshootingCarIssuesPrinter troubleshootingCarIssuesPrinter = new TroubleshootingCarIssuesPrinter();
    troubleshootingCarIssuesPrinter.printTroubleshootingCarIssues();
  }
}
