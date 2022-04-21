package com.example.licenta_spring.services;


import com.example.licenta_spring.domains.Payment;
import com.example.licenta_spring.repositories.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> getAll(){
        return paymentRepository.findAll();
    }

    public Optional<Payment> findById(String id){
        return paymentRepository.findById(id);
    }

    public List<Payment> findByTrainerId(String id){
        return paymentRepository.findAllByTrainerId(id);
    }

    public List<Payment> findByUserId(String id){
        return paymentRepository.findAllByUserId(id);
    }

    public List<Payment> findByMonth(String month){
        return paymentRepository.findAllByMonthCreated(month);
    }


}
