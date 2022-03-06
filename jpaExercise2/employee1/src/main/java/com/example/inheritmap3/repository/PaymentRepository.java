package com.example.inheritmap3.repository;

import com.example.inheritmap3.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment,Integer> {
}
