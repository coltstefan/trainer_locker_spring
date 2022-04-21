package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PaymentRepository
        extends MongoRepository<Payment, String> {


    List<Payment> findAllByTrainerId(String trainerId);
    List<Payment> findAllByUserId(String userId);
    List<Payment> findAllByMonthCreated(String month);

}
