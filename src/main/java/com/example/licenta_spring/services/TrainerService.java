package com.example.licenta_spring.services;


import com.example.licenta_spring.domains.Trainer;
import com.example.licenta_spring.repositories.TrainerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    public void save(Trainer trainer){
        trainerRepository.save(trainer);
    }

    public List<Trainer> getAll(){
        return trainerRepository.findAll();
    }

    public Optional<Trainer> findById(String id){
        return trainerRepository.findById(id);
    }

    public Trainer findByUsername(String username){
        return trainerRepository.findTrainerByUsername(username);
    }

}
