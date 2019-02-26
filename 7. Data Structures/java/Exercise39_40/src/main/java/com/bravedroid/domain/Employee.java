package com.bravedroid.domain;

import java.util.Objects;

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
  public int compareTo(Object other) {
    return lastName.compareTo(((Employee) other).lastName);
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(firstName, employee.firstName) &&
            Objects.equals(lastName, employee.lastName) &&
            Objects.equals(position, employee.position) &&
            Objects.equals(suppressionDate, employee.suppressionDate);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName, position, suppressionDate);
  }
}
