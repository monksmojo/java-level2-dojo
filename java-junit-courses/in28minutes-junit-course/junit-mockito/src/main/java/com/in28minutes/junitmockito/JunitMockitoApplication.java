package com.in28minutes.junitmockito;

import com.in28minutes.junitmockito.service.PrintComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitMockitoApplication implements CommandLineRunner {

	@Autowired
	private static PrintComponent printComponent;

	public static void main(String[] args)  {
		SpringApplication.run(JunitMockitoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		printComponent.executeService();
	}
}
