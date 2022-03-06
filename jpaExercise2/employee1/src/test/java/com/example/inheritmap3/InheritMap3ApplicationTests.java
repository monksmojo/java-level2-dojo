package com.example.inheritmap3;

import com.example.inheritmap3.entity.Cheque;
import com.example.inheritmap3.entity.CreditCard;
import com.example.inheritmap3.entity.Product;
import com.example.inheritmap3.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InheritMap3ApplicationTests {

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testCardPayment(){
		CreditCard cc=new CreditCard();
		cc.setPayeeName("father");
		cc.setAmount(13000);
		cc.setCardNumber("cc-4321");
		cc.addProduct(new Product("milky bar"));
		cc.addProduct(new Product("5 star"));
		paymentRepository.save(cc);
	}

	@Test
	void  testChequePayment(){
		Cheque cq=new Cheque();
		cq.setPayeeName("mother");
		cq.setAmount(14000);
		cq.setChequeNumber("cq-132418");
		paymentRepository.save(cq);
	}

}
