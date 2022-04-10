package com.example.licenta_spring.domains;


import com.example.licenta_spring.controllers.TrainerController;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Trainer implements Comparable<Trainer>{

    @Id
    private String id;

    @Indexed
    private String email;
    @Indexed
    private String username;

    private String firstName;
    private String lastName;
    private int totalOrders = 0;
    private int rating = 0;
    private List<String> trainingPlanIds = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(String email, String username, String firstName, String lastName) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getTrainingPlanIds() {
        return trainingPlanIds;
    }

    public void setTrainingPlanIds(List<String> trainingPlanIds) {
        this.trainingPlanIds = trainingPlanIds;
    }


    @Override
    public int compareTo(Trainer trainer) {





        return 0;
    }
}
