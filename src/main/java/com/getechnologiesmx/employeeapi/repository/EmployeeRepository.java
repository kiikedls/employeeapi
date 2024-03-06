package com.getechnologiesmx.employeeapi.repository;

import com.getechnologiesmx.employeeapi.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
