package com.example.licenta_spring.controllers;

import com.example.licenta_spring.domains.ExerciseSet;
import com.example.licenta_spring.domains.Trainer;
import com.example.licenta_spring.domains.TrainingDay;
import com.example.licenta_spring.domains.TrainingPlan;
import com.example.licenta_spring.helpers.IdHelperTrainingDay;
import com.example.licenta_spring.services.ExerciseSetService;
import com.example.licenta_spring.services.TrainerService;
import com.example.licenta_spring.services.TrainingDayService;
import com.example.licenta_spring.services.TrainingPlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@RestController
@RequestMapping("/api/v1/trainingPlan")
@AllArgsConstructor
public class TrainingPlanController{

    private final TrainingPlanService trainingPlanService;
    private final TrainerService trainerService;
    private final TrainingDayService trainingDayService;
    private final ExerciseSetService exerciseSetService;

    @GetMapping
    public ResponseEntity<List<TrainingPlan>> getAll() {
        try {
            return new ResponseEntity<>(trainingPlanService.getAll(), HttpStatus.OK);

        } catch (Exception err) {
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByTrainerId/{id}")
    public ResponseEntity<List<TrainingPlan>> getAllByTrainerId(@PathVariable String id) {
        try {

            List<TrainingPlan> trainingPlans = trainingPlanService.getAllByTrainerId(id);
            return new ResponseEntity<>(trainingPlans, HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Find By Trainer Id TP");
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<TrainingPlan> findById(@PathVariable String id) {
        try {

            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id);
            return new ResponseEntity<>(trainingPlan.get(), HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Find by Id TP");
            System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME));
            System.out.println(id);
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<TrainingPlan> createPlan(@RequestBody TrainingPlan trainingPlan) {
        try {
            trainingPlanService.save(trainingPlan);
            Optional<Trainer> trainer = trainerService.findById(trainingPlan.getTrainerId());
            trainer.get().getTrainingPlanIds().add(trainingPlan.getId());
            trainerService.save(trainer.get());
            return new ResponseEntity<>(trainingPlan, HttpStatus.OK);
        } catch (Exception err) {
            System.out.println("Create TP");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/addComment/{id_tp}")
    public ResponseEntity<Optional<TrainingPlan>> addComment(@RequestBody String id_comment, @PathVariable String id_tp) {
        try {
            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id_tp);
            trainingPlan.get().getCommentIds().add(id_comment.substring(21, id_comment.length() - 4));
            trainingPlanService.save(trainingPlan.get());
            return new ResponseEntity<>(trainingPlan, HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Add Comment TP");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/addTrainingDay/{id_tp}")
    public ResponseEntity<Optional<TrainingPlan>> addTrainingDay(@RequestBody IdHelperTrainingDay id_day, @PathVariable String id_tp) {
        try {
            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id_tp);
            trainingPlan.get().getTrainingDays().add(id_day.getTrainingDayId());
            trainingPlanService.save(trainingPlan.get());
            return new ResponseEntity<>(trainingPlan, HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Add Training Day TP");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/addClient/{id_tp}")
    public ResponseEntity<Optional<TrainingPlan>> addClient(@RequestBody String id_client, @PathVariable String id_tp) {
        try {
            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id_tp);
            trainingPlan.get().getUserIds().add(id_client.substring(18, id_client.length() - 4));
            trainingPlanService.save(trainingPlan.get());
            return new ResponseEntity<>(trainingPlan, HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Add Client TP");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/setTrainer/{id_tp}")
    public ResponseEntity<Optional<TrainingPlan>> setTrainer(@RequestBody String id_trainer, @PathVariable String id_tp) {
        try {
            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id_tp);
            trainingPlan.get().setTrainerId(id_trainer.substring(20, id_trainer.length() - 4));
            trainingPlanService.save(trainingPlan.get());
            return new ResponseEntity<>(trainingPlan, HttpStatus.OK);

        } catch (Exception err) {
            System.out.println("Set Trainer TP");
            System.out.println(LocalDateTime.now());
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TrainingPlan> deleteTrainingPlan(@PathVariable String id) {
        try {
            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id);
            for (String trainingDayId : trainingPlan.get().getTrainingDays()) {

                Optional<TrainingDay> trainingDay = trainingDayService.findTrainingDayById(trainingDayId);

                for (String exerciseSetId : trainingDay.get().getExerciseSetIds()) {

                    Optional<ExerciseSet> exerciseSet = exerciseSetService.findExerciseSetById(exerciseSetId);
                    exerciseSetService.deleteExercise(exerciseSet.get());
                }

                trainingDayService.delete(trainingDay.get());

            }
            trainingPlanService.delete(trainingPlan.get());
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Delete TP");
            System.out.println(LocalDateTime.now());
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
