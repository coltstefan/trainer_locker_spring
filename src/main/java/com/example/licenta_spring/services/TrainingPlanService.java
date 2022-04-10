package com.example.licenta_spring.services;

import com.example.licenta_spring.domains.TrainingPlan;
import com.example.licenta_spring.repositories.TrainingPlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TrainingPlanService {

    private final TrainingPlanRepository trainingPlanRepository;

    public void save(TrainingPlan trainingPlan){
        trainingPlanRepository.save(trainingPlan);
    }

    public List<TrainingPlan> getAll(){
        return trainingPlanRepository.findAll();
    }

    public List<TrainingPlan> getAllByTrainerId(String id){
        return trainingPlanRepository.findTrainingPlanByTrainerId(id);
    }

    public Optional<TrainingPlan> findById(String id){
        return trainingPlanRepository.findById(id);
    }

    public void delete(TrainingPlan trainingPlan){
        trainingPlanRepository.delete(trainingPlan);
    }

}
