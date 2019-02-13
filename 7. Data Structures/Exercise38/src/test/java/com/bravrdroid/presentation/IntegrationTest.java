package com.bravrdroid.presentation;

import com.bravrdroid.domain.EvenNumberFilter;
import com.bravrdroid.util.InputValidator;
import com.bravrdroid.util.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IntegrationTest {
  private FilteredValuesValidator SUT;
  private ReaderCmd readerMock;

  @Before
  public void setUp() {
    Logger logger = mock(Logger.class);
    readerMock = mock(ReaderCmd.class);
    SUT = new FilteredValuesValidator(readerMock, new EvenNumberFilter(), logger);
  }

  @Test
  public void shouldPrintEvenNumbersAfterFilter() throws IOException {
    when(readerMock.read()).thenReturn("44 22 2 1 111 55555 5559");
    final String result = SUT.printEvenNumbers();
    assertThat(result, is(equalTo("44 22 2")));
  }

  @Test
  public void testStreamsApiJava8() {
    String x = "45 22 111 a    ";
    final List<Integer> result = Arrays.stream(x.split(" "))
            .filter((String item) -> !InputValidator.isBlank(item))
            .filter(InputValidator::isNumeric)
            .map(s -> Integer.valueOf(s))
            .filter(value -> value % 2 == 0).collect(Collectors.toList());

    assertThat(result, is(equalTo(Arrays.asList(22))));
  }
}
