package com.bravedroid.businesslogic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.bravedroid.businesslogic.CharType.*;

public class CharDetector {
  public CharType detectCharType(char character) {
    final String string = Character.toString(character);
    String patternDigit = "(\\d)";
    String patternAlpha = "(\\w)";
    String patternPunct = "(\\p{Punct})";

    if (isPatternMatched(string, patternDigit)) return DIGIT;
    if (isPatternMatched(string, patternAlpha)) return ALPHA;
    if (isPatternMatched(string, patternPunct)) return PUNCT;
    return UNKNOWN;
  }

  private boolean isPatternMatched(String string, String pattern) {
    Pattern regex = Pattern.compile(pattern);
    Matcher matcher = regex.matcher(string);
    return matcher.find();
  }
}


