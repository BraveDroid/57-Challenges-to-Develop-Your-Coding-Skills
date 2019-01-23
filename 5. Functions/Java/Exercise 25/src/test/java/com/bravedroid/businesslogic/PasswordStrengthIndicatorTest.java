package com.bravedroid.businesslogic;

import com.bravedroid.businesslogic.exceptions.BadPasswordFormatException;
import com.bravedroid.businesslogic.utils.CharTypeSumStruct;
import com.bravedroid.businesslogic.utils.PasswordComplexity;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PasswordStrengthIndicatorTest {
  private PasswordStrengthIndicator SUT;

  @Before
  public void setUp() {
    SUT = new PasswordStrengthIndicator();
  }

  @Test
  public void getPasswordComplexity_ObjectInput_ReturnEnum() {
    CharTypeSumStruct vm = new CharTypeSumStruct(7, 0, 0, 0);
    PasswordComplexity result = SUT.getPasswordComplexity(vm,"1234557");
    PasswordComplexity expected = PasswordComplexity.VERY_WEAK_PASSWORD;
    assertEquals(expected, result);
  }
  @Test(expected = RuntimeException.class)
  public void getPasswordComplexity_invalidInput_exceptionExpected(){
    CharTypeSumStruct vm = new CharTypeSumStruct(9, 0, 0, 0);
    SUT.getPasswordComplexity(vm,"123123123");
  }
}
