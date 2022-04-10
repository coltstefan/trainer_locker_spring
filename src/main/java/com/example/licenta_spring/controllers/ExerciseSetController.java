package com.example.licenta_spring.controllers;

import com.example.licenta_spring.domains.Exercise;
import com.example.licenta_spring.domains.ExerciseSet;
import com.example.licenta_spring.services.ExerciseSetService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/exerciseSet")
@AllArgsConstructor
public class ExerciseSetController {

    private final ExerciseSetService exerciseSetService;

    @GetMapping
    public ResponseEntity<List<ExerciseSet>> getAll(){
        try{
            return new ResponseEntity<>(exerciseSetService.findAll() , OK);
        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<ExerciseSet> getById(@PathVariable String id){
        try{
            return new ResponseEntity<ExerciseSet>(exerciseSetService.findExerciseSetById(id).get() , OK);
        }catch (Exception e){
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ExerciseSet> createExerciseSet(@RequestBody ExerciseSet exerciseSet){
        try{
            exerciseSetService.saveExerciseSet(exerciseSet);
            return new ResponseEntity<>(exerciseSet,OK);
        }catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ExerciseSet> updateExerciseSet(@RequestBody String exerciseId , @PathVariable String id){
        try{
            Optional<ExerciseSet> es = exerciseSetService.findExerciseSetById(id);
            es.get().setExercise(exerciseId.substring(21,exerciseId.length()-4));
            exerciseSetService.saveExerciseSet(es.get());
            return new ResponseEntity<>(es.get(), OK);

        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, INTERNAL_SERVER_ERROR);
        }
    }

}
