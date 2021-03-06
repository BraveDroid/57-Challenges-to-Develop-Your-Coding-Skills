package com.bravedroid.businesslogic;

import com.bravedroid.businesslogic.utils.*;

import static com.bravedroid.businesslogic.utils.PasswordComplexity.*;

public class PasswordStrengthIndicator {
  public CharTypeSumStruct getSumCharTypeEnum(String password) {
    CharDetector charDetector = new CharDetector();
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

  //new variant of logic based on constant variables
  CharTypeSumStruct getSumCharTypeConst(String password) {
    CharDetector charDetector = new CharDetector();
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

  //new variant of logic based on obj
  CharTypeSumStruct getSumCharTypeObj(String password) {
    CharDetector charDetector = new CharDetector();
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

  public PasswordComplexity getPasswordComplexity(CharTypeSumStruct vm, String password) {
    if (isVeryWeakPassword(vm, password)) {
      return VERY_WEAK_PASSWORD;
    }
    if (isWeakPassword(vm, password)) {
      return WEAK_PASSWORD;
    }
    if (isStrongPassword(vm, password)) {
      return STRONG_PASSWORD;
    }
    if (isVeryStrongPassword(vm, password)) {
      return VERY_STRONG_PASSWORD;
    }
    if (haveUnknownCharacter(vm)) {
      return UNKNOWN_CHARACTER_PASSWORD;
    }
    // crashes for some example like 123123123
    throw new RuntimeException("Password complexity is not known ");
  }

  private boolean isVeryStrongPassword(CharTypeSumStruct vm, String password) {
    return vm.alphabeticSum > 0 &&
            vm.digitalSum > 0 &&
            vm.punctSum > 0 &&
            vm.unknownSum == 0 &&
            password.length() >= 8;
  }

  private boolean isStrongPassword(CharTypeSumStruct vm, String password) {
    return vm.alphabeticSum > 0 &&
            vm.digitalSum >= 1 &&
            vm.punctSum == 0 &&
            vm.unknownSum == 0 &&
            password.length() >= 8;
  }

  private boolean isWeakPassword(CharTypeSumStruct vm, String password) {
    return vm.alphabeticSum > 0 &&
            vm.digitalSum == 0 &&
            vm.punctSum == 0 &&
            vm.unknownSum == 0 &&
            password.length() < 8;
  }

  private boolean isVeryWeakPassword(CharTypeSumStruct vm, String password) {
    return vm.digitalSum > 0 &&
            vm.alphabeticSum == 0 &&
            vm.punctSum == 0 &&
            vm.unknownSum == 0 &&
            password.length() < 8;
  }

  private boolean haveUnknownCharacter(CharTypeSumStruct vm) {
    return vm.unknownSum > 0;
  }
}
