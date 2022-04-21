package com.example.licenta_spring.services;


import com.example.licenta_spring.domains.ProgressiveOverload;
import com.example.licenta_spring.repositories.ProgressiveOverloadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProgressiveOverloadService {

    private final ProgressiveOverloadRepository progressiveOverloadRepository;

    public ProgressiveOverload save(ProgressiveOverload progressiveOverload){
        return progressiveOverloadRepository.save(progressiveOverload);
    }

    public List<ProgressiveOverload> getAll(){
        return progressiveOverloadRepository.findAll();
    }

    public Optional<ProgressiveOverload> findById(String id){
        return progressiveOverloadRepository.findById(id);
    }

    public List<ProgressiveOverload> findByUserId(String id){
        return progressiveOverloadRepository.findProgressiveOverloadByUserId(id);
    }

    public void delete(ProgressiveOverload progressiveOverload){
        progressiveOverloadRepository.delete(progressiveOverload);
    }
}
