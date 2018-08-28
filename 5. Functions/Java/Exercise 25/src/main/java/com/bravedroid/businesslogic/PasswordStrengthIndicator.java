package com.bravedroid.businesslogic;

import com.bravedroid.businesslogic.exceptions.BadPasswordFormatException;
import com.bravedroid.businesslogic.utils.CharDetector;

import static com.bravedroid.businesslogic.utils.CharType.*;

public class PasswordStrengthIndicator {
  private String password;

  public String indicatePasswordStrength(String password) {
    this.password = password;
    final CharTypeSumStruct charTypeSumStruct = getSumCharType(password);
    return getPasswordComplexityMsg(charTypeSumStruct);
  }

  CharTypeSumStruct getSumCharType(String password) {
    char[] passwordArray = password.toCharArray();
    int digitalSum = 0, alphabeticSum = 0, punctSum = 0, unknownSum = 0;

    CharDetector charDetector = new CharDetector();
    for (char c : passwordArray) {
      if (charDetector.detectCharType(c) == DIGIT) {
        digitalSum++;
      } else if (charDetector.detectCharType(c) == ALPHA) {
        alphabeticSum++;
      } else if (charDetector.detectCharType(c) == PUNCT) {
        punctSum++;
      } else {
        unknownSum++;
      }
    }
    return new CharTypeSumStruct(digitalSum, alphabeticSum, punctSum, unknownSum);
  }

  String getPasswordComplexityMsg(CharTypeSumStruct vm) {
    StringBuilder messageToPrint = new StringBuilder();
    if (isVeryWeakPassword(vm)) {
      messageToPrint.append("The password ")
              .append("\'")
              .append(password)
              .append("\'")
              .append(" is a very weak password.");
    } else if (isWeakPassword(vm)) {
      messageToPrint.append("The password ")
              .append("\'")
              .append(password)
              .append("\'")
              .append(" is a weak password.");
    } else if (isStrongPassword(vm)) {
      messageToPrint.append("The password ")
              .append("\'").append(password)
              .append("\'")
              .append(" is a strong password.");
    } else if (isVeryStrongPassword(vm)) {
      messageToPrint.append("The password ")
              .append("\'")
              .append(password)
              .append("\'")
              .append(" is a very strong password.");
    } else if (vm.unknownSum > 0) {
      messageToPrint.append(" unknownSum character entered !!! ");
    } else {
      throw new BadPasswordFormatException("Invalid Password Format");
    }
    return messageToPrint.toString();
  }

  private boolean isVeryStrongPassword(CharTypeSumStruct vm) {
    return vm.alphabeticSum > 0 &&
            vm.digitalSum > 0 &&
            vm.punctSum > 0 &&
            vm.unknownSum == 0 &&
            password.length() >= 8;
  }

  private boolean isStrongPassword(CharTypeSumStruct vm) {
    return vm.alphabeticSum > 0 &&
            vm.digitalSum >= 1 &&
            vm.punctSum == 0 &&
            vm.unknownSum == 0 &&
            password.length() >= 8;
  }

  private boolean isWeakPassword(CharTypeSumStruct vm) {
    return vm.alphabeticSum > 0 &&
            vm.digitalSum == 0 &&
            vm.punctSum == 0 &&
            vm.unknownSum == 0 &&
            password.length() < 8;
  }

  private boolean isVeryWeakPassword(CharTypeSumStruct vm) {
    return vm.digitalSum > 0 &&
            vm.alphabeticSum == 0 &&
            vm.punctSum == 0 &&
            vm.unknownSum == 0 &&
            password.length() < 8;
  }

  /***
   *my Struct used to encapsulate the count of each CharType
   */
  static class CharTypeSumStruct {
    int digitalSum;
    int alphabeticSum;
    int punctSum;
    int unknownSum;

    CharTypeSumStruct(int digitalSum, int alphabeticSum, int punctSum, int unknownSum) {
      this.digitalSum = digitalSum;
      this.alphabeticSum = alphabeticSum;
      this.punctSum = punctSum;
      this.unknownSum = unknownSum;
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
}
