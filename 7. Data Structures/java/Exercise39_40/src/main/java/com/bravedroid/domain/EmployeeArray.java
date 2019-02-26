package com.bravedroid.domain;

public class EmployeeArray implements Comparable {
  private String[] array;

  public EmployeeArray(String firstName, String lastName, String position, String suppressionDate) {
    array = new String[]{firstName, lastName, position, suppressionDate};
  }

  @Override
  public int compareTo(Object other) {
    final EmployeeArray otherEmployeeArray = (EmployeeArray) other;
    final String otherEmployeeArrayLastName = otherEmployeeArray.array[1];
    return this.array[1].compareTo(otherEmployeeArrayLastName);
  }

  public String getFirstName() {
    return array[0];
  }

  public String getLastName() {
    return array[1];
  }

  public String getPosition() {
    return array[2];
  }

  public String getSuppressionDate() {
    return array[3];
  }
}
