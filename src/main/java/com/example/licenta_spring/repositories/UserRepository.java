package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.Optional;

public interface UserRepository
        extends MongoRepository<User,String> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUsername(String username);

}
