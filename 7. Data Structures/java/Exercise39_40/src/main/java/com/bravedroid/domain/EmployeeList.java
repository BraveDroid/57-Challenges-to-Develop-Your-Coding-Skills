package com.bravedroid.domain;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList implements Comparable {
  private List<String> list;

  public EmployeeList(String firstName, String lastName, String position, String suppressionDate) {
    list = new ArrayList<>();
    list.add(firstName);
    list.add(lastName);
    list.add(position);
    list.add(suppressionDate);
  }


  @Override
  public int compareTo(Object other) {
    final EmployeeList otherEmployeeList = (EmployeeList) other;
    final String otherEmployeeListLastName = otherEmployeeList.list.get(1);
    return this.list.get(1).compareTo(otherEmployeeListLastName);
  }

  public String getFirstName() {
    return list.get(0);
  }

  public String getLastName() {
    return list.get(1);
  }

  public String getPosition() {
    return list.get(2);
  }

  public String getSuppressionDate() {
    return list.get(3);
  }
}
