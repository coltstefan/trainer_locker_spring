package com.example.licenta_spring.repositories;


import com.example.licenta_spring.domains.Trainer;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.management.openmbean.OpenType;

public interface TrainerRepository
        extends MongoRepository<Trainer,String> {
    Trainer findTrainerByUsername(String  username);
}
