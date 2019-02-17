package com.bravedroid.data;

import com.bravedroid.domain.Employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRepositoryImpl implements Repository {
  private static final String PATH_NAME = "records.txt";

  @Override
  public List<Employee> getRecords() throws IOException {
    List<Employee> employeeList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(new File(PATH_NAME)))) {
      String line;
      while ((line = br.readLine()) != null) {
        final String[] records = splitLine(line);
        final String[] name = getName(records);
        Employee employee;
        if (records.length >= 3) {
          employee = new Employee(name[0], name[1], records[1], records[2]);
        } else {
          employee = new Employee(name[0], name[1], records[1], "");
        }
        employeeList.add(employee);
      }
    }
    return employeeList;
  }

  private String[] splitLine(String line) {
    return line.trim().split("\\|");
  }

  private String[] getName(String[] records) {
    return records[0].trim().split(" ");
  }
}
