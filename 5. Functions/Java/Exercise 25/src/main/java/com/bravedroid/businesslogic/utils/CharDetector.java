package com.bravedroid.businesslogic.utils;

import com.bravedroid.businesslogic.utils.CharAbs.AlphaChar;
import com.bravedroid.businesslogic.utils.CharAbs.DigitChar;
import com.bravedroid.businesslogic.utils.CharAbs.PunctChar;
import com.bravedroid.businesslogic.utils.CharAbs.UnknownChar;

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

  public CharAbs detectCharTypeAbs(char character) {
    final String string = Character.toString(character);
    String patternDigit = "(\\d)";
    String patternAlpha = "(\\p{Alpha})";
    String patternPunct = "(\\p{Punct})";

    if (isPatternMatched(string, patternDigit)) return new DigitChar();
    if (isPatternMatched(string, patternAlpha)) return new AlphaChar();
    if (isPatternMatched(string, patternPunct)) return new PunctChar();
    return new UnknownChar();
  }

  public int detectCharTypeConst(char character) {
    final String string = Character.toString(character);
    String patternDigit = "(\\d)";
    String patternAlpha = "(\\p{Alpha})";
    String patternPunct = "(\\p{Punct})";

    if (isPatternMatched(string, patternDigit)) return CharTypeConst.DIGIT;
    if (isPatternMatched(string, patternAlpha)) return CharTypeConst.ALPHA;
    if (isPatternMatched(string, patternPunct)) return CharTypeConst.PUNCT;
    return CharTypeConst.UNKNOWN;
  }

  private boolean isPatternMatched(String charString, String patternString) {
    return Pattern.compile(patternString)
            .matcher(charString)
            .find();
  }
}
