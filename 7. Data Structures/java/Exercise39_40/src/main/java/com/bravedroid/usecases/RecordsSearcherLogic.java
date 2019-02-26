package com.bravedroid.usecases;

import com.bravedroid.domain.Employee;

import java.util.ArrayList;
import java.util.List;

public class RecordsSearcherLogic {

  public List<Employee> search(String searchString, List<Employee> records) {
    List <Employee> searchResultList=new ArrayList<>();
    for (Employee item: records ) {
      if (item.getFirstName().contains(searchString)){
        searchResultList.add(item);
      }else if(item.getLastName().contains(searchString)){
        searchResultList.add(item);
      }
    }
    return searchResultList;
  }
}
