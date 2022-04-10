package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.TrainingPlan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TrainingPlanRepository
        extends MongoRepository<TrainingPlan,String> {

    List<TrainingPlan> findTrainingPlanByTrainerId(String id);

}
