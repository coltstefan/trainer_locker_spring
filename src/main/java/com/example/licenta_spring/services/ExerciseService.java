package com.example.licenta_spring.services;


import com.example.licenta_spring.domains.Exercise;
import com.example.licenta_spring.repositories.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    public List<Exercise> getAllExercises(){ return exerciseRepository.findAll(); }
    public Exercise saveExercise(Exercise exercise) {  return exerciseRepository.save(exercise);}
    public Optional<Exercise> findExerciseById(String id){ return exerciseRepository.findExerciseById(id); }


}
