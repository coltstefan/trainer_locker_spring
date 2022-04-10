package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ExerciseRepository
        extends MongoRepository<Exercise,String> {

    Optional<Exercise> findExerciseById(String id);

}
