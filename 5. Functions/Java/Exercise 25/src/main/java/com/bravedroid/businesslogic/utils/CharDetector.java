package com.bravedroid.businesslogic.utils;

import java.util.regex.Pattern;

import static com.bravedroid.businesslogic.utils.CharType.*;

public class CharDetector {

  public CharType detectCharType(char character) {
    final String string = Character.toString(character);
    String patternDigit = "(\\d)";
    String patternAlpha = "(\\p{Alpha})";
    String patternPunct = "(\\p{Punct})";

    if (isPatternMatched(string, patternDigit)) return DIGIT;
    if (isPatternMatched(string, patternAlpha)) return ALPHA;
    if (isPatternMatched(string, patternPunct)) return PUNCT;
    return UNKNOWN;
  }

  private boolean isPatternMatched(String charString, String patternString) {
    return Pattern.compile(patternString)
            .matcher(charString)
            .find();
  }
}
