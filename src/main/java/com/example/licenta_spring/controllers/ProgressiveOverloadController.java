package com.example.licenta_spring.controllers;


import com.example.licenta_spring.domains.ProgressiveOverload;
import com.example.licenta_spring.domains.TrainingPlan;
import com.example.licenta_spring.services.ProgressiveOverloadService;
import lombok.AllArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.OutputKeys;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/progressiveOverload")
@AllArgsConstructor
public class ProgressiveOverloadController{

    private final ProgressiveOverloadService progressiveOverloadService;

    @GetMapping
    public ResponseEntity<List<ProgressiveOverload>> getAll() {
        try {
            return new ResponseEntity<>(progressiveOverloadService.getAll(), HttpStatus.OK);

        } catch (Exception err) {
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<ProgressiveOverload> findById(@PathVariable String id) {
        try {

            Optional<ProgressiveOverload> progressiveOverload = progressiveOverloadService.findById(id);
            return new ResponseEntity<>(progressiveOverload.get(), HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Find by Id PROG  OVER");
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
            System.out.println(id);
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByUserId/{id}")
    public ResponseEntity<List<ProgressiveOverload>> findByUserId(@PathVariable String id){
        try {
            return new ResponseEntity<>(progressiveOverloadService.findByUserId(id), HttpStatus.OK);
        }catch (Exception err){
            System.out.println("PG BY USER ID");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/create")
    public ResponseEntity<ProgressiveOverload> createPGOV(@RequestBody ProgressiveOverload progressiveOverload){
        try{
            return new ResponseEntity<>(progressiveOverloadService.save(progressiveOverload), HttpStatus.OK);
        }catch (Exception err){
            System.out.println("CREATE PROGRESSIVE OVERLOAD OBJECT");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/editProg/{id_pg}")
    public ResponseEntity<Optional<ProgressiveOverload>> editOverload(@RequestBody ProgressiveOverload progressiveOverload, @PathVariable String id_pg){

        try{

            Optional<ProgressiveOverload> progressiveOverloadOptional = progressiveOverloadService.findById(id_pg);
            progressiveOverloadOptional.get().setExerciseId(progressiveOverload.getExerciseId());
            progressiveOverloadOptional.get().setReps(progressiveOverload.getReps());
            progressiveOverloadOptional.get().setSets(progressiveOverload.getSets());
            progressiveOverloadOptional.get().setWeight(progressiveOverload.getWeight());

            progressiveOverloadService.save(progressiveOverloadOptional.get());

            return new ResponseEntity<>(progressiveOverloadOptional,HttpStatus.OK);

        }catch (Exception err){
            System.out.println("EDIT PROG OVERLOAD");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProgressiveOverload> deleteProgOver(@PathVariable String id){

        try {
            Optional<ProgressiveOverload> progressiveOverloadOptional = progressiveOverloadService.findById(id);
            progressiveOverloadService.delete(progressiveOverloadOptional.get());
            return new ResponseEntity<>(null,HttpStatus.OK);
        }catch (Exception err){
            System.out.println("DELETE PROG OVER");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }



    }



}
