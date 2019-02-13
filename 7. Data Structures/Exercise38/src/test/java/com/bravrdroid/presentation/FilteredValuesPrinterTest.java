package com.bravrdroid.presentation;

import com.bravrdroid.domain.EvenNumberFilter;
import com.bravrdroid.util.InputValidator;
import com.bravrdroid.util.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FilteredValuesPrinterTest {
  private FilteredValuesValidator SUT;
  private ReaderCmd readerMock;
  private EvenNumberFilter evenNumberFilterMock;

  @Before
  public void setUp() {
    Logger logger = mock(Logger.class);
    readerMock = mock(ReaderCmd.class);
    evenNumberFilterMock = mock(EvenNumberFilter.class);
    SUT = new FilteredValuesValidator(readerMock, evenNumberFilterMock, logger);
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
  public void validateInput_correctInputEntered_ArrayOfIntsIsReturned() {
    final String inputFromUser1 = "1 2 8 4   8 2 20 33 333    2";
    final int[] ints1 = SUT.validateInput(inputFromUser1);
    assertThat(ints1, is(equalTo(new int[]{1, 2, 8, 4, 8, 2, 20, 33, 333, 2})));
    final String inputFromUser2 = "1";
    final int[] ints2 = SUT.validateInput(inputFromUser2);
    assertThat(ints2, is(equalTo(new int[]{1})));
  }
  @Test
  public void shouldPrintEvenNumbersAfterFilter() throws IOException {
    when(readerMock.read()).thenReturn("44 22 2 1 111 55555 5559");
    when(evenNumberFilterMock.filterEvenNumbers(any())).thenReturn(new int[]{44,252,2});
    final String result = SUT.printEvenNumbers();
    assertThat(result, is(equalTo("44 252 2")));
  }
}
