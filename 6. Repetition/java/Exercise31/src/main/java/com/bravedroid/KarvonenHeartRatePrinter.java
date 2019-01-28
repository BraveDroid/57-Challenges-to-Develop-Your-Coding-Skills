package com.bravedroid;

import java.io.IOException;

public interface KarvonenHeartRatePrinter {
  int RECURSION = 0;
  int INFINITE_LOOP = 1;

  static KarvonenHeartRatePrinter create(int strategyCode) {
    if (strategyCode == RECURSION) {
      return new KarvonenHeartRateRecursivePrinter();
    }
    if (strategyCode == INFINITE_LOOP) {
      return new KarvonenHeartRateInfiniteLoopPrinter();
    }
    throw new IllegalArgumentException("UNKNOWN STRATEGY");
  }

  void readAge() throws IOException;

  void readHeartRate() throws IOException;

  void printHeartRate();
}
