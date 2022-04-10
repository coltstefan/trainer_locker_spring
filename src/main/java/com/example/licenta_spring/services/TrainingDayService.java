package com.example.licenta_spring.services;


import com.example.licenta_spring.domains.TrainingDay;
import com.example.licenta_spring.repositories.TrainingDayRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TrainingDayService {

    private final TrainingDayRepository trainingDayRepository;

    public List<TrainingDay> getAll(){
        return trainingDayRepository.findAll();
    }

    public Optional<TrainingDay> findTrainingDayById(String id){
        return trainingDayRepository.findTrainingDayById(id);
    }

    public TrainingDay save(TrainingDay trainingDay){
        return trainingDayRepository.save(trainingDay);
    }

    public void delete(TrainingDay trainingDay){
        trainingDayRepository.delete(trainingDay);
    }

}
