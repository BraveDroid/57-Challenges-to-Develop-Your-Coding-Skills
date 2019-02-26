package com.bravedroid.domain;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMap implements Comparable {

  private final static String LAST_NAME_KEY = "LastName";
  private final static String FIRST_NAME_KEY = "FirstName";
  private final static String POSITION_KEY = "Position";
  private final static String SUPPRESSION_DATE_KEY = "SuppressionDate";
  private Map<String, String> map;

  public EmployeeMap(String firstName, String lastName, String position, String suppressionDate) {
    map = new HashMap<>();
    map.put(FIRST_NAME_KEY, firstName);
    map.put(LAST_NAME_KEY, lastName);
    map.put(POSITION_KEY, position);
    map.put(SUPPRESSION_DATE_KEY, suppressionDate);
  }

  public Map<String, String> getMap() {
    return map;
  }

  public String getLastName() {
    return map.get(LAST_NAME_KEY);
  }

  public String getFirstName() {
    return map.get(FIRST_NAME_KEY);
  }

  public String getPosition() {
    return map.get( POSITION_KEY);
  }

  public String getSuppressionDate() {
    return map.get(SUPPRESSION_DATE_KEY);
  }

  @Override
  public int compareTo(Object other) {
    final EmployeeMap otherEmployeeMap = ((EmployeeMap) other);
    final String otherEmployeeMapLastName = otherEmployeeMap.map.get(LAST_NAME_KEY);
    return this.map.get(LAST_NAME_KEY).compareTo(otherEmployeeMapLastName);
  }
}

