package com.bravedroid.businesslogic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AnagramCheckerTest {
  private AnagramChecker SUT;

  @Before
  public void setUp() {
    SUT = new AnagramChecker();
  }

  @Test
  public void isAnagram_twoStringsHavingNotEqualSeize_shouldReturnFalse() {
    String string1 = "abc";
    String string2 = "abcc";
    boolean returnedValue = SUT.isAnagram(string1, string2);
    assertFalse(returnedValue);
  }
  @Test
  public void isAnagram_twoStringsHavingEqualSeizeFirstCharNotInString2_shouldReturnFalse() {
    String string1 = "abc";
    String string2 = "bbc";
    boolean returnedValue = SUT.isAnagram(string1, string2);
    assertFalse(returnedValue);
  }
  @Test
  public void isAnagram_twoStringsHavingEqualSeizeSecondCharNotInString2_shouldReturnFalse() {
    String string1 = "abc";
    String string2 = "aac";
    boolean returnedValue = SUT.isAnagram(string1, string2);
    assertFalse(returnedValue);
  }
  @Test
  public void isAnagram_charInSecondArrayNotExistInFirstArray_shouldReturnFalse() {
    String string1 = "aac";
    String string2 = "abc";
    boolean returnedValue = SUT.isAnagram(string1, string2);
    assertFalse(returnedValue);
  }
  @Test
  public void isAnagram_charsInSecondArrayExistInFirstArray_shouldReturnTrue() {
    String string1 = "123";
    String string2 = "321";
    boolean returnedValue = SUT.isAnagram(string1, string2);
    assertTrue(returnedValue);
  }
  @Test
  public void isAnagram_sameCharsInSecondArrayExistInFirstArray_shouldReturnTrue() {
    String string1 = "reactive";
    String string2 = "creative";
    boolean returnedValue = SUT.isAnagram(string1, string2);
    assertTrue(returnedValue);
  }
}
