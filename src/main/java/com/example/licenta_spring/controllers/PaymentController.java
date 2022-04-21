package com.example.licenta_spring.controllers;

import com.example.licenta_spring.domains.Payment;
import com.example.licenta_spring.domains.ProgressiveOverload;
import com.example.licenta_spring.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/payment")
@AllArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;


    @GetMapping
    public ResponseEntity<List<Payment>> getAll(){
        try{
            return new ResponseEntity<>(paymentService.getAll(), HttpStatus.OK);
        }catch (Exception err){
            System.out.println("GET ALL PAYMENTS");
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Payment> findById(@PathVariable String id) {
        try {

            Optional<Payment> payment = paymentService.findById(id);
            return new ResponseEntity<>(payment.get(), HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Find by Id Payment");
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
            System.out.println(id);
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<List<Payment>> findByUserId(@PathVariable String id){
        try {
            return new ResponseEntity<>(paymentService.findByUserId(id), HttpStatus.OK);
        }catch (Exception err){
            System.out.println("Payment BY USER ID");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByTrainerId/{id}")
    public ResponseEntity<List<Payment>> findByTrainerId(@PathVariable String id){
        try {
            return new ResponseEntity<>(paymentService
                    .findByTrainerId(id), HttpStatus.OK);
        }catch (Exception err){
            System.out.println("Payment BY TRAINER ID");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment){
        try{
            return new ResponseEntity<>(paymentService.save(payment), HttpStatus.OK);
        }catch (Exception err){
            System.out.println("CREATE PAYMENT");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }







}
