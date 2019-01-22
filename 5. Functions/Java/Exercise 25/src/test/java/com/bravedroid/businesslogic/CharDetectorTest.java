package com.bravedroid.businesslogic;

import com.bravedroid.businesslogic.utils.CharAbs;
import com.bravedroid.businesslogic.utils.CharDetector;
import com.bravedroid.businesslogic.utils.CharType;
import org.junit.Before;
import org.junit.Test;

import static com.bravedroid.businesslogic.utils.CharType.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class CharDetectorTest {
  private CharDetector SUT;

  @Before
  public void setUp()  {
    SUT = new CharDetector();
  }

  @Test
  public void detectCharType_digitInput_returnEnumType() {
    final CharType returnType = SUT.detectCharType('9');
    assertEquals(DIGIT, returnType);
    final CharType returnType1 = SUT.detectCharType('z');
    assertEquals(ALPHA, returnType1);
    final CharType returnType2 = SUT.detectCharType('~');
    assertEquals(PUNCT, returnType2);
    final CharType returnType3 = SUT.detectCharType('§');
    assertEquals(UNKNOWN, returnType3);
  }

  @Test
  public void detectCharTypeConst_allInput_returnConstType() {
    final int returnType = SUT.detectCharTypeConst('9');
    assertEquals(1, returnType);
    final int returnType1 = SUT.detectCharTypeConst('a');
    assertEquals(0, returnType1);
    final int returnType2 = SUT.detectCharTypeConst('!');
    assertEquals(2, returnType2);
    final int returnType3 = SUT.detectCharTypeConst('£');
    assertEquals(-1, returnType3);
  }

  @Test
  public void detectCharTypeConst_allInput_returnObjectType() {
    final CharAbs returnType = SUT.detectCharTypeAbs('9');
    assertTrue(returnType instanceof CharAbs.DigitChar);
    final CharAbs returnType1 = SUT.detectCharTypeAbs('a');
    assertTrue(returnType1 instanceof CharAbs.AlphaChar);
    final CharAbs returnType2 = SUT.detectCharTypeAbs('!');
    assertTrue(returnType2 instanceof CharAbs.PunctChar);
    final CharAbs returnType3 = SUT.detectCharTypeAbs('£');
    assertTrue(returnType3 instanceof CharAbs.UnknownChar);
  }
}
