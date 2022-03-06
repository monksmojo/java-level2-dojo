package com.practice.javawebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JavaWebServiceApplication {



	public static void main(String[] args) {
//		BinarySearchImpl binarySearch=new BinarySearchImpl(new BubbleSort());
//		BinarySearchImpl binarySearch1=new BinarySearchImpl(new QuickSort());
//		binarySearch.binarySearch(new int[]{10,22,3},3);
//		binarySearch1.binarySearch(new int[]{10,2,3},3);
		ApplicationContext applicationContext = SpringApplication.run(JavaWebServiceApplication.class, args);
		BinarySearchImpl binarySearch=applicationContext.getBean(BinarySearchImpl.class);
		binarySearch.binarySearch(new int[]{10,20,30},3);
	}
}
