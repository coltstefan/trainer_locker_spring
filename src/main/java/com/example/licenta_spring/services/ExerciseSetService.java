package com.example.licenta_spring.services;

import com.example.licenta_spring.domains.ExerciseSet;
import com.example.licenta_spring.repositories.ExerciseSetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ExerciseSetService {

    private final ExerciseSetRepository exerciseSetRepository;

    public ExerciseSet saveExerciseSet(ExerciseSet exerciseSet){
        return exerciseSetRepository.save(exerciseSet);
    }

    public Optional<ExerciseSet> findExerciseSetById(String id){
        return exerciseSetRepository.findExerciseSetById(id);
    }

    public List<ExerciseSet> findAll(){
        return exerciseSetRepository.findAll();
    }
    public void deleteExercise(ExerciseSet exerciseSet){ exerciseSetRepository.delete(exerciseSet);}

}
