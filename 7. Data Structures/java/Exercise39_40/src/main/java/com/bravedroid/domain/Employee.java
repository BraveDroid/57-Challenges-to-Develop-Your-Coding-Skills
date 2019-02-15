package com.bravedroid.domain;

public class Employee implements Comparable {

  private String firstName;
  private String lastName;
  private String position;
  private String suppressionDate;

  public Employee(String firstName, String lastName, String position, String suppressionDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.position = position;
    this.suppressionDate = suppressionDate;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getPosition() {
    return position;
  }

  public String getSuppressionDate() {
    return suppressionDate;
  }

  @Override
  public int compareTo(Object o) {
    return lastName.compareTo(((Employee) o).lastName);
  }

  @Override
  public String toString() {
    return "Employee{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", position='" + position + '\'' +
            ", suppressionDate='" + suppressionDate + '\'' +
            '}';
  }
}
