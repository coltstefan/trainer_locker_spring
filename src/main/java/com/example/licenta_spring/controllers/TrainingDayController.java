package com.example.licenta_spring.controllers;


import com.example.licenta_spring.domains.TrainingDay;
import com.example.licenta_spring.helpers.IdHelperExerciseSet;
import com.example.licenta_spring.services.TrainingDayService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/trainingDay")
@AllArgsConstructor
public class TrainingDayController {

    private final TrainingDayService trainingDayService;

    @GetMapping
    public ResponseEntity<List<TrainingDay>> getAll(){
        try{
            return new ResponseEntity<>(trainingDayService.getAll(),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<TrainingDay> getById(@PathVariable String id){
        try{
            return new ResponseEntity<TrainingDay>(trainingDayService.findTrainingDayById(id).get(),HttpStatus.OK);
        }catch (Exception e){
            System.out.println("Find by Id TD");
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<TrainingDay> createTD(@RequestBody TrainingDay trainingDay){
        try{
            return new ResponseEntity<>(trainingDayService.save(trainingDay) , HttpStatus.OK);

        }catch (Exception e){
            System.out.println("Create TD");
            return new ResponseEntity<>(null , HttpStatus.INTERNAL_SERVER_ERROR);}
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TrainingDay> updateTD(@RequestBody IdHelperExerciseSet exerciseSetId , @PathVariable String id){
        try{
            Optional<TrainingDay> td = trainingDayService.findTrainingDayById(id);
            td.get().getExerciseSetIds().add(exerciseSetId.getExerciseSetId());
            trainingDayService.save(td.get());
            return new ResponseEntity<>(td.get(),HttpStatus.OK);

        }catch (Exception err){
            System.out.println("Add Exercise Set TD");
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
