package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.ExerciseSet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExerciseSetRepository
        extends MongoRepository<ExerciseSet,String> {

    Optional<ExerciseSet> findExerciseSetById(String id);

}
