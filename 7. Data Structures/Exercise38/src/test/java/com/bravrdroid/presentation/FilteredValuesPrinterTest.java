package com.bravrdroid.presentation;

import com.bravrdroid.domain.EvenNumberDetector;
import com.bravrdroid.util.InputValidator;
import com.bravrdroid.util.Logger;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class FilteredValuesPrinterTest {
  private FilteredValuesPrinter SUT;

  @Before
  public void setUp() {
    SUT = new FilteredValuesPrinter(new EvenNumberDetector(), new Logger(true));
  }

  @Test(expected = InputValidator.MustExitException.class)
  public void validateInput_exitIsEntered_MustExitExceptionIsThrown() {
    final String inputFromUser = "exit";
    SUT.validateInput(inputFromUser);
  }

  @Test(expected = InputValidator.WrongInputException.class)
  public void validateInput_blankIsEntered_WrongInputExceptionIsThrown() {
    final String inputFromUser1 = "   ";
    SUT.validateInput(inputFromUser1);
    final String inputFromUser2 = "";
    SUT.validateInput(inputFromUser2);
  }

  @Test(expected = InputValidator.WrongInputException.class)
  public void validateInput_nonAllNumericEntered_WrongInputExceptionIsThrown() {
    final String inputFromUser1 = "h hjk 748";
    SUT.validateInput(inputFromUser1);
    final String inputFromUser2 = "a";
    SUT.validateInput(inputFromUser2);
  }

  @Test
  public void validateInput_correctInputEntered_ArrayOfIntsIsREturned() {
    final String inputFromUser1 = "1 2 8 4   8 2 20 33 333    2";
    final int[] ints1 = SUT.validateInput(inputFromUser1);
    assertThat(ints1, is(equalTo(new int[]{1, 2, 8, 4, 8, 2, 20, 33, 333, 2})));
    final String inputFromUser2 = "1";
    final int[] ints2 = SUT.validateInput(inputFromUser2);
    assertThat(ints2, is(equalTo(new int[]{1})));
  }
}
