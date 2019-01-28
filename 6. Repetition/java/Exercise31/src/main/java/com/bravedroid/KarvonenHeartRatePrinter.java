package com.bravedroid;

import java.io.IOException;

public interface KarvonenHeartRatePrinter {
  int RECURSION = 1;
  int INFINITE_LOOP = 0;

  static KarvonenHeartRatePrinter create(int strategyCode) {
    KarvonenHeartRatePrinter karvonenHeartRatePrinter = null;
    if (strategyCode == RECURSION) {
      karvonenHeartRatePrinter = new KarvonenHeartRateRecursivePrinter();
    } else if (strategyCode == INFINITE_LOOP) {
      karvonenHeartRatePrinter = new KarvonenHeartRateInfiniteLoopPrinter();
    }
    return karvonenHeartRatePrinter;
  }

  void readAge() throws IOException;

  void readHeartRate() throws IOException;

  void printHeartRate();
}
