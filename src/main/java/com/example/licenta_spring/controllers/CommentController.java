package com.example.licenta_spring.controllers;

import com.example.licenta_spring.domains.Comment;
import com.example.licenta_spring.domains.TrainingPlan;
import com.example.licenta_spring.services.CommentService;
import com.example.licenta_spring.services.TrainingPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final TrainingPlanService trainingPlanService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAll(){
        try{
            return new ResponseEntity<>(commentService.findAll(),HttpStatus.OK);

        }catch (Exception err){
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByTrainingPlanId/{id}")
    public ResponseEntity<List<Comment>> getAllByTP(@PathVariable String id){
        try{
            return new ResponseEntity<>(commentService.findCommentByTraniningPlanId(id),HttpStatus.OK);

        }catch (Exception err){
            System.out.println("GET COMMENTS BY TP");
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Comment> createComm(@RequestBody Comment comment){
        try{

            Comment comment1 = commentService.save(comment);
            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(comment.getTrainingPlanId());
            trainingPlan.get().getCommentIds().add(comment.getId());
            trainingPlanService.save(trainingPlan.get());

            return new ResponseEntity<Comment>(comment1,HttpStatus.OK);

        }catch (Exception err){
            System.out.println(err);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
