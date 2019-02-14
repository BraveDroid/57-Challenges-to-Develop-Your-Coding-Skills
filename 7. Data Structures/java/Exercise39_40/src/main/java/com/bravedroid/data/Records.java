package com.bravedroid.data;

import com.bravedroid.domain.Employee;

import java.util.Arrays;
import java.util.List;

public class Records {

  public static final List<Employee> ALL = Arrays.asList(
          new Employee("John", "Johnson", "Manager", "2016-12-31"),
          new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05"),
          new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19"),
          new Employee("Jake", "Jacobson", "Programmer", ""),
          new Employee("Jacquelyn", "Jackson", "DBA", ""),
          new Employee("Sally", "Weber", "Web Developer", "2015-12-18")
  );
}
