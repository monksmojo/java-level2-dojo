package com.example.employee1;

import com.example.employee1.entity.Employee;
import com.example.employee1.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void contextLoads() {
	}

	@Test // count employee
	public void testCountEmployee() {
		System.out.println("total number of employees------->" + employeeRepository.count());
	}

	@Test // create employee
	public void testCreateEmployee(){
		Employee emp=new Employee();
		emp.setFirstName("robin");
		emp.setLastName("hoood");
		emp.setAge(23);
		emp.setSalary(23000.00);
		employeeRepository.save(emp);
		emp.setFirstName("puginder");
		emp.setLastName("singh");
		emp.setAge(58);
		emp.setSalary(50000);
		employeeRepository.save(emp);
	}



	@Test // read employee
	public void testReadEmployee(){
		List<Employee> empList=employeeRepository.getAllEmployee();
		empList.forEach(e-> System.out.println(e));
	}

	@Test// average salary
	public void testAvgSalary(){
		Double avgSalary=employeeRepository.avgSalary();
		System.out.println("---------------");
		System.out.println("average salary---->"+avgSalary);
		System.out.println("----------------");
	}

	@Test// min salary
	public void testMinSalary(){
		Double minSalary=employeeRepository.minSalary();
		System.out.println("---------------");
		System.out.println("minimum salary---->"+minSalary);
		System.out.println("----------------");
	}

	//JPQL

	@Test //Q-1 Display the first name, last name of all employees having salary greater than average salary
		  // ordered in ascending by their age and in descending by their salary.
	void testSortEmployeeData(){
		List<Object[]> records=employeeRepository.sortEmployeeData();
		for(Object[] record:records){
			for (Object data:record){
				System.out.print(data+" ");
			}
			System.out.println("");
		}
	}


	@Test //Q-2 Update salary of all employees by a salary passed as a parameter
			// whose existing salary is less than the average salary.
	@Transactional
	@Rollback(false)
	void testUpdateEmployeeSalary(){
		employeeRepository.updateEmployeeSalary(40000.00,employeeRepository.avgSalary());
		System.out.println("-----------------");
		System.out.println("salary updated");
		System.out.println("------------------");
	}

	@Test // Q-3 Delete all employees with minimum salary.
	@Transactional
	@Rollback(false)
	public void testDeleteEmployeeWithMinSal(){
		employeeRepository.deleteEmployeeWithMinSal(employeeRepository.minSalary());
		System.out.println("-----------------");
		System.out.println("minimum salary deleted");
		System.out.println("------------------");
	}

	// Native Sql Querry

	//Q-1 //Display the id, first name, age of all employees
	// where last name ends with "singh"
	@Test
	public void testdisplayEmployeeDataNQ(){
		List<Object[]> records=employeeRepository.displayEmployeeDataNQ();
		for (Object[] record:records) {
			for (Object data:record){
				System.out.print(data+" ");
			}
			System.out.println("");
		}
	}

	//Q-2 Delete all employees with age greater than 45(Should be passed as a parameter)
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteEmployeeWithAge(){
		employeeRepository.deleteEmployeeByAgeGreaterThan(45);
		System.out.println("-----------------");
		System.out.println("employees deleted");
		System.out.println("------------------");
	}




}
