package com.bravedroid.usecases;

import com.bravedroid.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class RecordsSorterLogicTest {

  private RecordsSorterLogic SUT;

  @Before
  public void setUp() {
    SUT = new RecordsSorterLogic();
  }

  @Test
  public void sortRecordsTest_peopleListEntered_PeopleSortedListIsEntered() {
    final Map<String, List<Employee>> peopleLists = createPeopleLists();
    final List<Employee> employeeListInput = peopleLists.get("FIRST");
    final List<Employee> sortedResult = SUT.sortListOfEmployees(employeeListInput);
    final List<Employee> sortedExpected = peopleLists.get("SECOND");
    assertThat(sortedResult, is(equalTo(sortedExpected)));
  }


  private Map<String, List<Employee>> createPeopleLists() {
    final List<Employee> employeeListInput = new ArrayList<>();
    Employee employee1 = new Employee("salma", "gharbi", "secretaire", "02/02/2015");
    Employee employee2 = new Employee("fathi", "majdoub", "fale7", "10/02/2017");
    Employee employee3 = new Employee("hichem", "shweli", "baladiya", "02/08/2000");
    Employee employee4 = new Employee("sihem", "gar3oun", "khayata", "15/02/1977");
    employeeListInput.add(employee1);
    employeeListInput.add(employee2);
    employeeListInput.add(employee3);
    employeeListInput.add(employee4);


    final List<Employee> employeeListExpected = new ArrayList<>();
    employeeListExpected.add(employee4);
    employeeListExpected.add(employee1);
    employeeListExpected.add(employee2);
    employeeListExpected.add(employee3);

    final HashMap<String, List<Employee>> map = new HashMap<>();
    map.put("FIRST", employeeListInput);
    map.put("SECOND", employeeListExpected);
    return map;
  }
  private  Pair createPeopleLists2() {
    final List<Employee> employeeListInput = new ArrayList<>();
    Employee employee1 = new Employee("salma", "gharbi", "secretaire", "02/02/2015");
    Employee employee2 = new Employee("fathi", "majdoub", "fale7", "10/02/2017");
    Employee employee3 = new Employee("hichem", "shweli", "baladiya", "02/08/2000");
    Employee employee4 = new Employee("sihem", "gar3oun", "khayata", "15/02/1977");
    employeeListInput.add(employee1);
    employeeListInput.add(employee2);
    employeeListInput.add(employee3);
    employeeListInput.add(employee4);


    final List<Employee> employeeListExpected = new ArrayList<>();
    employeeListExpected.add(employee4);
    employeeListExpected.add(employee1);
    employeeListExpected.add(employee2);
    employeeListExpected.add(employee3);

    final Pair pair = new Pair();
    pair.first= employeeListInput;
    pair.second= employeeListExpected;
    return pair;
  }

  static class Pair {
     List<Employee> first;
     List<Employee> second;
  }
}
