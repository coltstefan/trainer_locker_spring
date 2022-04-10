package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.TrainingDay;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TrainingDayRepository
        extends MongoRepository<TrainingDay,String> {

    Optional<TrainingDay> findTrainingDayById(String id);

}
