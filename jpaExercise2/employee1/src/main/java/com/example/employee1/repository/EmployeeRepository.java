package com.example.employee1.repository;

import com.example.employee1.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query("from Employee")
    public List<Employee> getAllEmployee();

    @Query("select avg(salary) from Employee")
    public Double avgSalary();

    @Query("select MIN(salary) from Employee")
    public Double minSalary();

    //jpql
    //Q-1
    @Query("select firstName,lastName from Employee where salary>(select avg(salary) from Employee) order by age asc, salary desc")
    public List<Object[]> sortEmployeeData();

    //Q-2
    @Modifying
    @Query("update Employee set salary=:varSal where salary <:avgSal ")
    public void updateEmployeeSalary(@Param("varSal") Double varSal,@Param("avgSal") Double avgSal);

    //Q-3
    @Modifying
    @Query("delete from Employee where salary=:minSal")
    public void deleteEmployeeWithMinSal(@Param("minSal") Double minSal);

    // native SQl

    //Q-1
    @Query(value =" select empId,empFirstName,empAge from employeeTable where empLastName like 'singh' ",nativeQuery = true)
    public List<Object[]> displayEmployeeDataNQ();

    //Q-2
    @Modifying
    @Query(value = "delete from employeeTable where empAge>:age",nativeQuery = true)
    void deleteEmployeeByAgeGreaterThan(@Param("age") int age);

}
