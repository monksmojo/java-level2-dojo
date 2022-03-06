package com.example.componentmap;


import com.example.componentmap.entity.Salary;
import com.example.componentmap.entity.Worker;
import com.example.componentmap.repository.WorkerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ComponentMappingApplicationTests {

	@Autowired
	WorkerRepository workerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateWorker(){
		Worker w1=new Worker();
		w1.setFirstName("tony");
		w1.setLastName("stark");
		w1.setAge(34);
		Salary s1=new Salary();
		s1.setBasicSalary(13000.00);
		s1.setBonusSalary(4000.00);
		s1.setSpecialAllowanceSalary(500.00);
		s1.setTaxAmount(2000.00);
		w1.setSalary(s1);
		workerRepository.save(w1);
	}


}