package com.example.licenta_spring.controllers;


import com.example.licenta_spring.domains.Exercise;
import com.example.licenta_spring.domains.User;
import com.example.licenta_spring.services.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/exercise")
@AllArgsConstructor
public class ExerciseCotnroller {

    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<Exercise>> getAllExercises(){

        try {

            return new ResponseEntity<>(exerciseService.getAllExercises(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("findById/{id}")
    public ResponseEntity<Exercise> getExById(@PathVariable String id){
        try {

            return new ResponseEntity<Exercise>(exerciseService.findExerciseById(id).get(), HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/create")
    public ResponseEntity<Optional<Exercise>> saveExercise(@RequestBody Exercise exercise){
        try{
            exerciseService.saveExercise(exercise);
            return new ResponseEntity<Optional<Exercise>>((Optional<Exercise>) null,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
