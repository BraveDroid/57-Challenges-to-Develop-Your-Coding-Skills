package com.bravedroid.businesslogic;

import com.bravedroid.businesslogic.exceptions.BadPasswordFormatException;
import com.bravedroid.businesslogic.utils.CharAbs;
import com.bravedroid.businesslogic.utils.CharDetector;
import com.bravedroid.businesslogic.utils.CharTypeConst;

import java.util.Objects;

public class PasswordStrengthIndicator {
  private String password;
  private CharDetector charDetector = new CharDetector();

  public String indicatePasswordStrength(String password) {
    this.password = password;
    final CharTypeSumStruct charTypeSumStruct = getSumCharTypeEnum(password);
    return getPasswordComplexityMsg(charTypeSumStruct);
  }

  CharTypeSumStruct getSumCharTypeEnum(String password) {
    char[] passwordArray = password.toCharArray();
    int digitalSum = 0, alphabeticSum = 0, punctSum = 0, unknownSum = 0;
    for (char c : passwordArray) {
      switch (charDetector.detectCharType(c)) {
        case DIGIT:
          digitalSum++;
          break;
        case ALPHA:
          alphabeticSum++;
          break;
        case PUNCT:
          punctSum++;
          break;
        default:
          unknownSum++;
          break;
      }
    }
    return new CharTypeSumStruct(digitalSum, alphabeticSum, punctSum, unknownSum);
  }

  CharTypeSumStruct getSumCharTypeConst(String password) {
    char[] passwordArray = password.toCharArray();
    int digitalSum = 0, alphabeticSum = 0, punctSum = 0, unknownSum = 0;
    for (char c : passwordArray) {
      if (charDetector.detectCharTypeConst(c) == CharTypeConst.DIGIT) {
        digitalSum++;
      } else if (charDetector.detectCharTypeConst(c) == CharTypeConst.ALPHA) {
        alphabeticSum++;
      } else if (charDetector.detectCharTypeConst(c) == CharTypeConst.PUNCT) {
        punctSum++;
      } else {
        unknownSum++;
      }
    }
    return new CharTypeSumStruct(digitalSum, alphabeticSum, punctSum, unknownSum);
  }

  CharTypeSumStruct getSumCharTypeObj(String password) {
    char[] passwordArray = password.toCharArray();
    int digitalSum = 0, alphabeticSum = 0, punctSum = 0, unknownSum = 0;
    for (char c : passwordArray) {
      if (charDetector.detectCharTypeAbs(c) instanceof CharAbs.DigitChar) {
        digitalSum++;
      } else if (charDetector.detectCharTypeAbs(c) instanceof CharAbs.AlphaChar) {
        alphabeticSum++;
      } else if (charDetector.detectCharTypeAbs(c) instanceof CharAbs.PunctChar) {
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
}
