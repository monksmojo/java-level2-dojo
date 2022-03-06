package com.example.inheritmap.repository;

import com.example.inheritmap.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InheritRepository extends CrudRepository<Employee,Integer> {

}
