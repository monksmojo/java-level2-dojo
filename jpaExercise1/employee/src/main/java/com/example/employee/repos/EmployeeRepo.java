package com.example.employee.repos;

import com.example.employee.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {
    // PagingAndSortingRepository extends CurdRepository

    List<Employee>findByName(String name); // finder for Q-8

    List<Employee>findByNameLike(String name);// finder for Q-9

    List<Employee>findByAgeBetween(int age1,int age2); // finder for Q-10

}
