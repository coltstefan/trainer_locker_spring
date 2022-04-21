package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.ProgressiveOverload;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProgressiveOverloadRepository
        extends MongoRepository<ProgressiveOverload,String> {
    Optional<ProgressiveOverload> findProgressiveOverloadById(String id);
    List<ProgressiveOverload> findProgressiveOverloadByUserId(String id);


}
