package com.udemy.imtiazAhmad.pma.repository;

import com.udemy.imtiazAhmad.pma.entity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
