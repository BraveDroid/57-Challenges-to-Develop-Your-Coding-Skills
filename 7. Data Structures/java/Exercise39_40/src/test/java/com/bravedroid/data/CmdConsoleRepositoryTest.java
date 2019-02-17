package com.bravedroid.data;

import com.bravedroid.domain.Employee;
import com.bravedroid.presentation.ReaderCmd;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CmdConsoleRepositoryTest {

  private CmdConsoleRepository SUT;
  private ReaderCmd readerMock;

  @Before
  public void setUp(){
    readerMock = mock(ReaderCmd.class);
    SUT = new CmdConsoleRepository(readerMock);

  }

  @Test
  public void getRecordsTest_returnList() throws IOException {
    when(readerMock.readInput()).thenReturn("julia kk cto");
    final List<Employee> result = SUT.getRecords(5);
    List<Employee> expectedList = new ArrayList<>();
    expectedList.add(new Employee("julia", "kk", "cto", ""));
    expectedList.add(new Employee("julia", "kk", "cto", ""));
    expectedList.add(new Employee("julia", "kk", "cto", ""));
    expectedList.add(new Employee("julia", "kk", "cto", ""));
    expectedList.add(new Employee("julia", "kk", "cto", ""));
    assertThat(result, is(equalTo(expectedList)));
  }

  @Test
  public void getRecords_returnEmptyList() throws IOException {
    when(readerMock.readInput()).thenReturn("");
    final List<Employee> result = SUT.getRecords(1);
    List<String[]> expected = new ArrayList<>() ;
    assertThat(result, is(equalTo(expected)));
  }

  @Test
  public void getRecords_returnEmptyArrayOfStringInList () throws IOException {
    when(readerMock.readInput()).thenReturn("julia ");
    final List<Employee> result = SUT.getRecords(1);
    List<String[]> expected = new ArrayList<>() ;
    assertThat(result, is(equalTo(expected)));
  }

  @Test
  public void isSeparatedByWhiteSpace() {
    final boolean result1 = SUT.isSeparatedByWhiteSpace("");
    final boolean result2 = SUT.isSeparatedByWhiteSpace("john scott");
    assertFalse(result1);
    assertTrue(result2);
  }

  @Test
 public void hasNecessaryData() {
   final boolean result1 = SUT.hasNecessaryData(new String[]{"john", "scott"});
   final boolean result2 = SUT.hasNecessaryData(new String[]{"john", "scott", "CEO"});
   assertFalse(result1);
   assertTrue(result2);
 }
}
