package com.bravedroid.usecases;

import com.bravedroid.domain.Employee;

import java.util.Collections;
import java.util.List;

public class RecordsSorterLogic {
  public List<Employee> sortRecords(List<Employee> records) {
    Collections.sort(records);
    return records;
  }
}
