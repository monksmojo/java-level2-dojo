package com.example.employee;

import com.example.employee.entities.Employee;
import com.example.employee.repos.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeApplicationTests {
    @Autowired
    EmployeeRepo employeeRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void createEmployee() { //create Q-3
        Employee emp1 = new Employee();
        emp1.setId(11);
        emp1.setName("jimmy");
        emp1.setAge(45);
        emp1.setLoc("berlin");
        employeeRepo.save(emp1);
        Employee emp2 = new Employee();
        emp2.setId(12);
        emp2.setName("dom");
        emp2.setAge(16);
        emp2.setLoc("brimingham");
        employeeRepo.save(emp2);
    }

    @Test
    public void updateEmployee() { //update Q-4
        if (employeeRepo.existsById(12)) {
            System.out.println("------employee exist--------");
            Employee emp = employeeRepo.findById(12).get();
            emp.setLoc("london"); // updating employee location
            employeeRepo.save(emp);
        } else {
            System.out.println("------employee not exist--------");
        }
    }

    @Test // Read Q-5
    public void readEmployee() {
        Employee emp = employeeRepo.findById(13).get();
        assertNotNull(emp);
        assertEquals("matt", emp.getName());
        System.out.println("reading employee data");
        System.out.println(emp.getName() + "-------------->" + emp.getLoc());// reading the data
        System.out.println("--------------------------------------------");
    }

    @Test //Delete Q-5
    public void deleteEmployee() {
        if (employeeRepo.existsById(11)) {
            System.out.println("------employee exist--------");
            employeeRepo.deleteById(11); // deleting the employee
        } else {
            System.out.println("------employee not exist--------");
        }
    }

    @Test //count employee Q-6
    public void countEmployee() {
        System.out.println("total number of employees------->" + employeeRepo.count());
    }

    @Test //(7) Implement Pagination and Sorting on the bases of Employee Age
	public void pagingEmployee(){
		Pageable pageable= PageRequest.of(0,5, Sort.Direction.DESC,"age");
		Page<Employee> employees=employeeRepo.findAll(pageable);
		employees.forEach(e-> System.out.println(e.getName()+"--"+e.getAge()));
	}

    @Test //Q-8Create and use finder to find Employee by Name
    public void findEmployeeByName() {
        List<Employee> employees = employeeRepo.findByName("zedd");
        employees.forEach(p -> System.out.println(p.toString()));
    }

    @Test //(9) Create and use finder to find Employees starting with 'A' character
    public void findEmployeeByCharacter() {
        List<Employee> employees = employeeRepo.findByNameLike("A%");
        employees.forEach(p -> System.out.println(p.toString()));
    }


	@Test //(10) Create and use finder to find Employees Between the age of 28 to 32
	public  void findEmployeeByAge(){
		List<Employee> employees = employeeRepo.findByAgeBetween(28,32);
		employees.forEach(e-> System.out.println(e.getName()+"--"+e.getAge()));
	}
}
