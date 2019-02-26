package com.bravedroid.usecases;

import com.bravedroid.domain.Employee;
import com.bravedroid.domain.EmployeeArray;
import com.bravedroid.domain.EmployeeList;
import com.bravedroid.domain.EmployeeMap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static com.bravedroid.data.Records.LAST_NAME_KEY;

public class RecordsSorterLogic {
  // List<Employee>
  public List<Employee> sortListOfEmployees(List<Employee> records) {
    Collections.sort(records);
  //  Collections.sort(records, new Comparator<Employee>() {
  //    @Override
  //    public int compare(Employee employee1, Employee employee2) {
  //      return employee1.getLastName().compareTo(employee2.getLastName());
  //    }
  //  });
    return records;
  }

  // List<Map<String, String>>
  public List<Map<String, String>> sortListOfMaps(List<Map<String, String>> records) {
    Collections.sort(records, new Comparator<Map>() {
      @Override
      public int compare(Map employee1, Map employee2) {

        final String lastName1 = (String) employee1.get(LAST_NAME_KEY);
        final String lastName2 = (String) employee2.get(LAST_NAME_KEY);

        return lastName1.compareTo(lastName2);
      }
    });
    return records;
  }

  // List<EmployeeMap>
  public List<EmployeeMap> sortListOfEmployeeMap(List<EmployeeMap> records) {
    Collections.sort(records);
  //Collections.sort(records, new Comparator<EmployeeMap>() {
  //  @Override
  //  public int compare(EmployeeMap employee1, EmployeeMap employee2) {
  //    final String lastName1 = employee1.map.get(LAST_NAME_KEY);
  //    final String lastName2 = employee2.map.get(LAST_NAME_KEY);

  //    return lastName1.compareTo(lastName2);
  //  }
  //});
    return records;
  }

  // List<List<String>>
  public List<List<String>> sortListOfString(List<List<String>> records) {
    Collections.sort(records, new Comparator<List<String>>() {
      @Override
      public int compare(List<String> employee1, List<String> employee2) {
        final String lastName1 = employee1.get(1);
        final String lastName2 = employee2.get(1);

        return lastName1.compareTo(lastName2);
      }
    });
    return records;
  }

  // List<EmployeeList>
  public List<EmployeeList> sortListOfEmployeeList(List<EmployeeList> records) {
    Collections.sort(records);
  // Collections.sort(records, new Comparator<EmployeeList>() {
  //   @Override
  //   public int compare(EmployeeList employee1, EmployeeList employee2) {
  //     final String lastName1 = employee1.getLastName();
  //     final String lastName2 = employee2.getLastName();
  //     return lastName1.compareTo(lastName2);
  //   }
  // });
    return records;
  }

  // List<String[]>
  public List<String[]> sortListOfArray(List<String[]> records) {
    Collections.sort(records, new Comparator<String[]>() {
      @Override
      public int compare(String[] employee1, String[] employee2) {
        final String lastName1 = employee1[1];
        final String lastName2 = employee2[1];
        return lastName1.compareTo(lastName2);
      }
    });
    return records;
  }

  // List<EmployeeArray>
  public List<EmployeeArray> sortListOfEmployeeArrayList(List<EmployeeArray> records) {
    Collections.sort(records);
  // Collections.sort(records, new Comparator<EmployeeArray>() {
  //   @Override
  //   public int compare(EmployeeArray employee1, EmployeeArray employee2) {
  //     final String lastName1 = employee1.employeeArray[1];
  //     final String lastName2 = employee2.employeeArray[1];
  //     return lastName1.compareTo(lastName2);
  //   }
  // });
    return records;
  }
}
