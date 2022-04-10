package com.example.licenta_spring.services;

import com.example.licenta_spring.domains.User;
import com.example.licenta_spring.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserByEmail(String email){ return userRepository.findUserByEmail(email); }
    public void saveUser(User user){ userRepository.save(user);}
    public Optional<User> findUserByUsername(String username){ return userRepository.findUserByUsername(username);
    };
    public Optional<User> findUserById(String id){ return userRepository.findById(id);
    };


}
