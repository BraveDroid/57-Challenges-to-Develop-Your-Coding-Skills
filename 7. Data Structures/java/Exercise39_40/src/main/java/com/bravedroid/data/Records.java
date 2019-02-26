package com.bravedroid.data;
//@formatter:off

import com.bravedroid.domain.Employee;
import com.bravedroid.domain.EmployeeArray;
import com.bravedroid.domain.EmployeeList;
import com.bravedroid.domain.EmployeeMap;

import java.util.*;

//Records is always providing a list of items , these items have to have a model structure
// In this sample we will use a various DSs ( data structures ) to represent our item which is obviously our domain model
// First model    :  Employee(a custom value object that knows how to represent its data/state (ex: first name )) and have a behavior compareTo() which helps us to sort it via  Collections.sort

// Second model   :  Map(Map<String, String>) and we use Collection.sort(list, new Comparator<Map>(){...}) because Map Type doesn't have the compareTo Behavior, and java does not have the possibility to add such extension (like Kotlin)
// Third model    :  EmployeeMap Map<String, String> class uses Map , just a wrapper for the Map class, uses compareTo because it is comparable

// Fourth Model   :  List<EmployeeList>
// Fifth Model    :  List<List<String>>

// sixth Model    :  List<String[]>
// seventh Model :   List<EmployeeArray>

public class Records {

  //////////////////////////////////////  Employee  ////////////////////////////////////////////////////////////////////


  public static final List<Employee> ALL_1 = Arrays.asList(
          new Employee("John", "Johnson", "Manager", "2016-12-31"),
          new Employee("Tou", "Xiong", "Software Engineer", "2016-10-05"),
          new Employee("Michaela", "Michaelson", "District Manager", "2015-12-19"),
          new Employee("Jake", "Jacobson", "Programmer", ""),
          new Employee("Jacquelyn", "Jackson", "DBA", ""),
          new Employee("Sally", "Weber", "Web Developer", "2015-12-18")
  );


  //////////////////////////////////////  Map<String, String>  /////////////////////////////////////////////////////////


  public final static String LAST_NAME_KEY = "LastName";
  public final static String FIRST_NAME_KEY = "FirstName";
  public final static String POSITION_KEY = "Position";
  public final static String SUPPRESSION_DATE_KEY = "SuppressionDate";

  private static Map<String, String> johnRecord = new HashMap<>();
  private static Map<String, String> touRecord = new HashMap<>();
  private static Map<String, String> michaelaRecord = new HashMap<>();
  private static Map<String, String> jakeRecord = new HashMap<>();
  private static Map<String, String> jacquelynRecord = new HashMap<>();
  private static Map<String, String> sallyRecord = new HashMap<>();

  public static final List<Map<String, String>> ALL_2 = Arrays.asList(johnRecord,
          touRecord,
          michaelaRecord,
          jakeRecord,
          jacquelynRecord,
          sallyRecord);


  static {
    johnRecord.put(LAST_NAME_KEY, "John");
    johnRecord.put(FIRST_NAME_KEY, "Johnson");
    johnRecord.put(POSITION_KEY, "Manager");
    johnRecord.put(SUPPRESSION_DATE_KEY, "2016-12-31");

    touRecord.put(LAST_NAME_KEY, "Tou");
    touRecord.put(FIRST_NAME_KEY, "Xiong");
    touRecord.put(POSITION_KEY, "Software Engineer");
    touRecord.put(SUPPRESSION_DATE_KEY, "2016-10-05");

    michaelaRecord.put(LAST_NAME_KEY, "Michaela");
    michaelaRecord.put(FIRST_NAME_KEY, "Michaelson");
    michaelaRecord.put(POSITION_KEY, "District Manager");
    michaelaRecord.put(SUPPRESSION_DATE_KEY, "2015-12-19");

    jakeRecord.put(LAST_NAME_KEY, "Jake");
    jakeRecord.put(FIRST_NAME_KEY, "Jacobson");
    jakeRecord.put(POSITION_KEY, "Programmer");
    jakeRecord.put(SUPPRESSION_DATE_KEY, "");

    jacquelynRecord.put(LAST_NAME_KEY, "Jacquelyn");
    jacquelynRecord.put(FIRST_NAME_KEY, "Jackson");
    jacquelynRecord.put(POSITION_KEY, "DBA");
    jacquelynRecord.put(SUPPRESSION_DATE_KEY, "");

    sallyRecord.put(LAST_NAME_KEY, "Sally");
    sallyRecord.put(FIRST_NAME_KEY, "Weber");
    sallyRecord.put(POSITION_KEY, "Web Developer");
    sallyRecord.put(SUPPRESSION_DATE_KEY, "2015-12-18");
  }


  //////////////////////////////////////  EmployeeMap  /////////////////////////////////////////////////////////////////


  public static final List<EmployeeMap> ALL_3 = Arrays.asList(
          new EmployeeMap("John", "Johnson", "Manager", "2016-12-31"),
          new EmployeeMap("Tou", "Xiong", "Software Engineer", "2016-10-05"),
          new EmployeeMap("Michaela", "Michaelson", "District Manager", "2015-12-19"),
          new EmployeeMap("Jake", "Jacobson", "Programmer", ""),
          new EmployeeMap("Jacquelyn", "Jackson", "DBA", ""),
          new EmployeeMap("Sally", "Weber", "Web Developer", "2015-12-18")
  );


  //////////////////////////////////////  List<String>  ////////////////////////////////////////////////////////////////


  public static List<EmployeeList> ALL_4 = new ArrayList<>();
  static {
    ALL_4.add(new EmployeeList("John", "Johnson", "Manager", "2016-12-31"));
    ALL_4.add(new EmployeeList("Tou", "Xiong", "Software Engineer", "2016-10-05"));
    ALL_4.add(new EmployeeList("Michaela", "Michaelson", "District Manager", "2015-12-19"));
    ALL_4.add(new EmployeeList("Jake", "Jacobson", "Programmer", ""));
    ALL_4.add(new EmployeeList("Jacquelyn", "Jackson", "DBA", ""));
    ALL_4.add(new EmployeeList("Sally", "Weber", "Web Developer", "2015-12-18"));
  }


  //////////////////////////////////////  List<String>  ////////////////////////////////////////////////////////////////


  public static List<List<String>> ALL_5 = new ArrayList<>();

  private static List<String> employeeRecorsList1 = new ArrayList<>();
  private static List<String> employeeRecorsList2 = new ArrayList<>();
  private static List<String> employeeRecorsList3 = new ArrayList<>();
  private static List<String> employeeRecorsList4 = new ArrayList<>();
  private static List<String> employeeRecorsList5 = new ArrayList<>();
  private static List<String> employeeRecorsList6 = new ArrayList<>();


  static {
    employeeRecorsList1.add("John");
    employeeRecorsList1.add("Johnson");
    employeeRecorsList1.add("Manager");
    employeeRecorsList1.add("2016-12-31");

    employeeRecorsList2.add("Tou");
    employeeRecorsList2.add("Xiong");
    employeeRecorsList2.add("Software Engineer");
    employeeRecorsList2.add("2016-10-05");

    employeeRecorsList3.add("Michaela");
    employeeRecorsList3.add("Michaelson");
    employeeRecorsList3.add("District Manager");
    employeeRecorsList3.add("2015-12-19");

    employeeRecorsList4.add("Jake");
    employeeRecorsList4.add("Jacobson");
    employeeRecorsList4.add("Programmer");
    employeeRecorsList4.add("");

    employeeRecorsList5.add("Jacquelyn");
    employeeRecorsList5.add("Jackson");
    employeeRecorsList5.add("DBA");
    employeeRecorsList5.add("");

    employeeRecorsList6.add("Sally");
    employeeRecorsList6.add("Weber");
    employeeRecorsList6.add("Web Developer");
    employeeRecorsList6.add("2015-12-18");

    ALL_5.add(employeeRecorsList1);
    ALL_5.add(employeeRecorsList2);
    ALL_5.add(employeeRecorsList3);
    ALL_5.add(employeeRecorsList4);
    ALL_5.add(employeeRecorsList5);
    ALL_5.add(employeeRecorsList6);
  }


  //////////////////////////////////////  Array<String>  ///////////////////////////////////////////////////////////////


  public static List<String[]> ALL_6 = new ArrayList<>();

  static {
    ALL_6.add(new String[]{"John", "Johnson", "Manager", "2016-12-31"});
    ALL_6.add(new String[]{"Tou", "Xiong", "Software Engineer", "2016-10-05"});
    ALL_6.add(new String[]{"Michaela", "Michaelson", "District Manager", "2015-12-19"});
    ALL_6.add(new String[]{"Jake", "Jacobson", "Programmer", ""});
    ALL_6.add(new String[]{"Jacquelyn", "Jackson", "DBA", ""});
    ALL_6.add(new String[]{"Sally", "Weber", "Web Developer", "2015-12-18"});
  }


  //////////////////////////////////////  Array<EmployeeArray>  ////////////////////////////////////////////////////////


  public static List<EmployeeArray> ALL_7 = new ArrayList<>();

  static {
    ALL_7.add(new EmployeeArray("John", "Johnson", "Manager", "2016-12-31"));
    ALL_7.add(new EmployeeArray("Tou", "Xiong", "Software Engineer", "2016-10-05"));
    ALL_7.add(new EmployeeArray("Michaela", "Michaelson", "District Manager", "2015-12-19"));
    ALL_7.add(new EmployeeArray("Jake", "Jacobson", "Programmer", ""));
    ALL_7.add(new EmployeeArray("Jacquelyn", "Jackson", "DBA", ""));
    ALL_7.add(new EmployeeArray("Sally", "Weber", "Web Developer", "2015-12-18"));
  }
}
//@formatter:off
