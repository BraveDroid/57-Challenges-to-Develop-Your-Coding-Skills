package com.bravedroid.usecases;

import com.bravedroid.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RecordsSearcherLogicTest {
  RecordsSearcherLogic SUT;
  public static final List<Employee> ALL_1 = Arrays.asList(
          new Employee("John", "Johnson", "Manager", "2016-12-31"),
          new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05"),
          new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19"),
          new Employee("Jake", "Jacobson", "Programmer", ""),
          new Employee("Jacquelyn", "Jackson", "DBA", ""),
          new Employee("Sally", "Weber", "Web Developer", "2015-12-18")
  );

  @Before
  public void setUp() throws Exception {
    SUT = new RecordsSearcherLogic();
  }

  @Test
  public void search() {
    SUT.search("Jac",ALL_1);

  }


}
