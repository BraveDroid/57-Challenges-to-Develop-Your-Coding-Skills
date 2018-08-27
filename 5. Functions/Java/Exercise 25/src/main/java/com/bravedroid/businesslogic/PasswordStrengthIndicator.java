package com.bravedroid.businesslogic;

import static com.bravedroid.businesslogic.CharType.ALPHA;
import static com.bravedroid.businesslogic.CharType.DIGIT;
import static com.bravedroid.businesslogic.CharType.PUNCT;

public class PasswordStrengthIndicator {
  private int digital;
  private int alphabetic;
  private int specialCharacter;
  private int unknown;
  private PasswordStrengthVM passwordStrengthVM;
  private CharDetector charDetector;

  public PasswordStrengthIndicator() {
    passwordStrengthVM = new PasswordStrengthVM();
    charDetector = new CharDetector();
  }

  public PasswordStrengthVM indicatePasswordStrength(String password) {
    char[] passwordArray = password.toCharArray();
    for (char c : passwordArray) {
      if (charDetector.detectCharType(c) == DIGIT) {
        digital++;
      } else if (charDetector.detectCharType(c) == ALPHA) {
        alphabetic++;
      } else if (charDetector.detectCharType(c) == PUNCT) {
        specialCharacter++;
      } else {
        unknown++;
      }
    }
    passwordStrengthVM.digital = digital;
    passwordStrengthVM.alphabetic = alphabetic;
    passwordStrengthVM.SpecialCharacter = specialCharacter;
    passwordStrengthVM.unknown = unknown;
    return passwordStrengthVM;
  }
}
