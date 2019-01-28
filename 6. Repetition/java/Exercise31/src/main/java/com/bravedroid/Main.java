package com.bravedroid;
import java.io.IOException;
import static com.bravedroid.KarvonenHeartRatePrinter.INFINITE_LOOP;

public class Main {
  public static void main(String[] args) throws IOException {
    final KarvonenHeartRatePrinter karvonenHeartRatePrinter = KarvonenHeartRatePrinter.create(INFINITE_LOOP);
    karvonenHeartRatePrinter.readAge();
    karvonenHeartRatePrinter.readHeartRate();
    karvonenHeartRatePrinter.printHeartRate();
  }
}
