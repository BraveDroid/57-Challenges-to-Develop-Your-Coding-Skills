package com.bravedroid.data;

import com.bravedroid.domain.Employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Repository {
 List<Employee> getRecords() throws IOException;
}
