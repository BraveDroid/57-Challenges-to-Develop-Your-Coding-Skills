package com.bravedroid.businesslogic.utils;

import com.bravedroid.businesslogic.PasswordStrengthIndicator;

import java.util.Objects;

public class CharTypeSumStruct {
 public int digitalSum;
  public int alphabeticSum;
  public int punctSum;
  public int unknownSum;

  public CharTypeSumStruct(int digitalSum, int alphabeticSum, int punctSum, int unknownSum) {
    this.digitalSum = digitalSum;
    this.alphabeticSum = alphabeticSum;
    this.punctSum = punctSum;
    this.unknownSum = unknownSum;
  }

  @Override
  public int hashCode() {
    return Objects.hash(digitalSum, alphabeticSum, punctSum, unknownSum);
  }

  @Override
  public boolean equals(Object other) {
    return (other instanceof CharTypeSumStruct) &&
            this.alphabeticSum == ((CharTypeSumStruct) other).alphabeticSum &&
            this.digitalSum == ((CharTypeSumStruct) other).digitalSum &&
            this.punctSum == ((CharTypeSumStruct) other).punctSum &&
            this.unknownSum == ((CharTypeSumStruct) other).unknownSum;
  }
}


