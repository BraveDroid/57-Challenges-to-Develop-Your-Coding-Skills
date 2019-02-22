package com.bravedroid;

import com.bravedroid.presentation.ReaderCmd;
import com.bravedroid.presentation.RecordsOps;
import com.bravedroid.util.Printer;
import com.bravedroid.util.ValidateInput;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    final ReaderCmd readerCmd = new ReaderCmd();
    RecordsOps recordsOps =new RecordsOps(readerCmd);
    try{
      recordsOps.promptForOperation();
    }catch (ValidateInput.MustExitException ignored){
      Printer.print("GOOD BYE :)");
    }
  }
}
