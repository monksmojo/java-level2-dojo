package com.example.inheritmap;

import com.example.inheritmap.entity.RegularEmployee;
import com.example.inheritmap.entity.TraineeEmployee;
import com.example.inheritmap.repository.InheritRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritMapApplicationTests {

	@Autowired
	InheritRepository inheritRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCreateEmployees(){
		RegularEmployee remp=new RegularEmployee(14,"guru","singh",50000,47,"hdfc");
		RegularEmployee remp1=new RegularEmployee(11,"harsimran","singh",50000,47,"tata-sky");
		TraineeEmployee temp=new TraineeEmployee(12,"gurbindar","singh",15000,36,"drupal");
		TraineeEmployee temp1=new TraineeEmployee(13,"taranjeet","singh",15000,36,"dev-ops");
		inheritRepository.save(remp);
		inheritRepository.save(remp1);
		inheritRepository.save(temp);
		inheritRepository.save(temp1);
	}

}
