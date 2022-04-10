package com.example.licenta_spring.controllers;


import com.example.licenta_spring.domains.Trainer;
import com.example.licenta_spring.domains.TrainingPlan;
import com.example.licenta_spring.domains.User;
import com.example.licenta_spring.services.TrainerService;
import com.example.licenta_spring.services.TrainingPlanService;
import com.example.licenta_spring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/trainer")
public class TrainerController {

    private final TrainerService trainerService;
    private final UserService userService;
    private TrainingPlanService trainingPlanService;


    @GetMapping
    public ResponseEntity<List<Trainer>> getAllTrainers(){
        try {
            return new ResponseEntity<>(trainerService.getAll(),HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findByUsername/{username}")
    public ResponseEntity<Trainer> findByUsername(@PathVariable String username){
        try{

            Trainer trainer = trainerService.findByUsername(username);
            return new ResponseEntity<Trainer>(trainer,HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Trainer> findById(@PathVariable String id){
        try{

            Optional<Trainer> trainer = trainerService.findById(id);
            return new ResponseEntity<Trainer>(trainer.get(),HttpStatus.OK);

        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    int totalTPs(Trainer trainer){
//        System.out.println("5");
//        List<String> trainingPlanList = trainer.getTrainingPlanIds();
//        int sum = 0;
//
//        for (String id : trainingPlanList){
//            System.out.println("6");
//
//            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(id);
//            System.out.println("7");
//            sum+= trainingPlan.get().getUserIds().size();
//            System.out.println("8");
//        }
//        System.out.println("SUMA ESTE " + sum);
//        return sum;
//    }
//
//    @GetMapping("/popular")
//    public ResponseEntity<List<Trainer>> getPopularTrainers(){
//        try {
//
//            System.out.println("1");
//            List<Trainer> trainerList = trainerService.getAll();
//            System.out.println("2");
//            for(int i = 0 ; i < trainerList.size()-1 ; i++){
//                for (int j = i+1; j<trainerList.size();i++){
//                    System.out.println("3");
//                    System.out.println(totalTPs(trainerList.get(i)) + " " + totalTPs(trainerList.get(j)));
//                    if (totalTPs(trainerList.get(i)) < totalTPs(trainerList.get(j))){
//                        System.out.println("4");
//                        Trainer aux = trainerList.get(i);
//                        trainerList.set(i,trainerList.get(j));
//                        trainerList.set(j,aux);
//                    }
//                }
//            }
//
//            return new ResponseEntity<>(trainerList, HttpStatus.OK);
//
//
//        }catch (Exception e){
//            System.out.println("GET POPULAR TRAINERS");
//            System.out.println(e);
//            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/create")
    public ResponseEntity<Trainer> createTrainer(@RequestBody Trainer trainer){
        try {
            trainerService.save(trainer);
            Optional<User> user = userService.findUserByUsername(trainer.getUsername());
            user.get().setTrainer(true);
            userService.saveUser(user.get());
            return new ResponseEntity<>(trainer,HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/addTrainingPlan/{id_trainer}")
    public ResponseEntity<Trainer> addTrainingPlan(@RequestBody String id_plan, @PathVariable String id_trainer){
        try{
            Optional<Trainer> trainer = trainerService.findById(id_trainer);
            trainer.get().getTrainingPlanIds().add(id_plan.substring(26,id_plan.length()-4));
            trainerService.save(trainer.get());
            return new ResponseEntity<>(trainer.get(),HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
