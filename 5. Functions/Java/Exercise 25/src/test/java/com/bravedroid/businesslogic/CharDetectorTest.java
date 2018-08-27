package com.bravedroid.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static com.bravedroid.businesslogic.CharType.*;
import static org.junit.Assert.*;

public class CharDetectorTest {
  private CharDetector SUT;

  @Before
  public void setUp() throws Exception {
    SUT = new CharDetector();
  }

  @Test
  public void detectCharType_digitInput_returnDigitType() {
    final CharType returnType = SUT.detectCharType('9');
    assertEquals(DIGIT, returnType);
  }

  @Test
  public void detectCharType_alphaInput_returnAlphaType() {
    final CharType returnType = SUT.detectCharType('z');
    assertEquals(ALPHA, returnType);
  }

  @Test
  public void detectCharType_punctInput_returnPunctType() {
    final CharType returnType = SUT.detectCharType('~');
    assertEquals(PUNCT, returnType);
  }

  @Test
  public void detectCharType_unknownInput_returnUnknownType() {
    final CharType returnType = SUT.detectCharType('§');
    assertEquals(UNKNOWN, returnType);
  }

}
