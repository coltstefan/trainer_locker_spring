package com.example.licenta_spring.controllers;


import com.example.licenta_spring.domains.TrainingPlan;
import com.example.licenta_spring.domains.User;
import com.example.licenta_spring.helpers.IdHelper;
import com.example.licenta_spring.services.TrainerService;
import com.example.licenta_spring.services.TrainingPlanService;
import com.example.licenta_spring.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final TrainerService trainerService;
    private final TrainingPlanService trainingPlanService;



    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){

        try{

            List<User> usersList = new ArrayList<User>();
            usersList = userService.getAllUsers();

            return new ResponseEntity<>(usersList,HttpStatus.OK);

        }
        catch (Exception e){
            //return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("email/{email}")
    public ResponseEntity<Optional<User>> getUserByEmail(@PathVariable String email){

        try{

            Optional<User> user;
            user = userService.getUserByEmail(email);

            return new ResponseEntity<>(user,HttpStatus.OK);

        }
        catch (Exception e){
            //return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("findByUsername/{username}")
    public ResponseEntity<User> findByUser(@PathVariable String username){
        try{
            Optional<User> user = userService.findUserByUsername(username);
            return new ResponseEntity<User>(user.get(),HttpStatus.OK);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Optional<User>> registerUser(@RequestBody User user){
        try{
            userService.saveUser(user);
            return new ResponseEntity<Optional<User>>((Optional<User>) null,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<Optional<User>>((Optional<User>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Optional<User>> loginUser(@RequestBody User user){
        try{
            Optional<User> FutureUser= userService.findUserByUsername(user.getUsername());
            System.out.println(FutureUser.get().getPassword());
            System.out.println(user.getPassword());
            if(FutureUser != null){
                System.out.println("Not null");
                if(FutureUser.get().getPassword().equals(user.getPassword())){
                    System.out.println("PASSWORD GOOD");
                    return new ResponseEntity<Optional<User>>(FutureUser, HttpStatus.OK);
                }
                else {
                    return new ResponseEntity<>((Optional<User>) null,HttpStatus.BAD_REQUEST);
                }
            }
            else{
                return new ResponseEntity<>((Optional<User>) null,HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            return new ResponseEntity<>((Optional<User>) null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> addOrder(@RequestBody IdHelper idHelper , @PathVariable String id){
        try{
            System.out.println(idHelper);
            Optional<User> user = userService.findUserById(id);
            user.get().getTrainingPlanIds().add(idHelper.getIdHelper());
            userService.saveUser(user.get());

            Optional<TrainingPlan> trainingPlan = trainingPlanService.findById(idHelper.getIdHelper());
            TrainingPlan debug = trainingPlan.get();
            debug.getUserIds().add(user.get().getId());

            trainingPlanService.save(trainingPlan.get());

            return new ResponseEntity<>(user.get(),HttpStatus.OK);

        }catch (Exception err){
            System.out.println(err);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
