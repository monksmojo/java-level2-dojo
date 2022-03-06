package com.example.inheritmap2;

import com.example.inheritmap2.entity.Gym;
import com.example.inheritmap2.entity.Yoga;
import com.example.inheritmap2.repository.TrainingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritMap2ApplicationTests {

	@Autowired
	TrainingRepository trainingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testYogaMembership(){
		Yoga y1=new Yoga();
		y1.setTraineeName("piku");
		y1.setCenterLocation("pune");
		y1.setHours(1);
		trainingRepository.save(y1);
	}

	@Test
	public void testGymMembership(){
		Gym g1=new Gym();
		g1.setTraineeName("bani j");
		g1.setGymLocation("delhi");
		g1.setHours(2);
		trainingRepository.save(g1);
	}

}
