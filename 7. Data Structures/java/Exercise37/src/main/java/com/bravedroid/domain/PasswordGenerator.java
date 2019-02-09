package com.bravedroid.domain;

import com.bravedroid.util.Logger;

import java.util.Random;

public class PasswordGenerator {
  private Random rand;
  private Logger logger;

  public PasswordGenerator(Logger logger) {
    rand = new Random();
    this.logger = logger;
  }

  public String rearrangePassword(int minimumLength, int punctCount, int digitCount) {
    final char[] passwordInCharsArray = (getPunctInPassword(punctCount) + getDigitInPassword(digitCount) + getAlphaInPassword(minimumLength, punctCount, digitCount)).toCharArray();
    logger.log("the password array char before transformation : " + concatenateArray(passwordInCharsArray));
    final String rearrangeResult = rearrange(passwordInCharsArray);
    logger.log(rearrangeResult);
    logger.log("password length is :" + rearrangeResult.length());
    logger.log("password special Character are :" + getPunctInPassword(punctCount));
    logger.log("password digits is :" + getDigitInPassword(digitCount));
    logger.log("password alpha is :" + getAlphaInPassword(minimumLength, punctCount, digitCount));

    return rearrangeResult;
  }

  private String getPunctInPassword(int punctCount) {
    StringBuilder password = new StringBuilder();
    for (int i = 1; i <= punctCount; i++) {
      int index = rand.nextInt(Characters.punct.length - 1);
      password.append(Characters.punct[index]);
    }
    return password.toString();
  }

  private String getDigitInPassword(int digitCount) {
    StringBuilder password = new StringBuilder();
    for (int i = 1; i <= digitCount; i++) {
      int index = rand.nextInt(Characters.digit.length - 1);
      password.append(Characters.digit[index]);
    }
    return password.toString();
  }

  private String getAlphaInPassword(int minimumLength, int punctCount, int digitCount) {
    StringBuilder password = new StringBuilder();
    int countAlpha = findCountAlpha(minimumLength, punctCount, digitCount);
    for (int i = 1; i <= countAlpha; i++) {
      int index = rand.nextInt(Characters.alpha.length - 1);
      password.append(Characters.alpha[index]);
    }
    return password.toString();
  }

  private int findCountAlpha(int minimumPasswordLength, int punctCount, int digitCount) {
    int sumOfPuntAndDigit = punctCount + digitCount;
    int minimumAlpha = minimumPasswordLength - sumOfPuntAndDigit;
    final int countAlpha1 = rand.nextInt(Math.max(digitCount, punctCount) + 1);
    if (sumOfPuntAndDigit < minimumPasswordLength) {
      return countAlpha1 + minimumAlpha;
    }
    return countAlpha1;
  }

  private String concatenateArray(char[] passwordInCharsArray) {
    StringBuilder password = new StringBuilder();
    for (char item : passwordInCharsArray) {
      password.append(String.valueOf(item));
    }
    return password.toString();
  }

  private String rearrange(char[] passwordInCharsArray) {
    int i = 0;
    while (true) {
      int randomIndex = rand.nextInt(passwordInCharsArray.length - 1);
      if (randomIndex != i) {
        char x = passwordInCharsArray[randomIndex];
        char y = passwordInCharsArray[i];
        passwordInCharsArray[randomIndex] = y;
        passwordInCharsArray[i] = x;
        i++;
      }
      if (i >= passwordInCharsArray.length / 2) {
        break;
      }
    }
    StringBuilder password = new StringBuilder();
    for (char item : passwordInCharsArray) {
      password.append(String.valueOf(item));
    }
    return password.toString();
  }
}
