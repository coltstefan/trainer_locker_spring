package com.example.licenta_spring.domains;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class TrainingPlan implements Comparable<TrainingPlan> {

    @Id
    private String id;

    private String name;
    private int duration;
    private Double price;
    private List<String> commentIds = new ArrayList<>();
    private List<String> userIds = new ArrayList<>();
    private List<String> trainingDays = new ArrayList<>();
    private String trainerId;

    public TrainingPlan(String name, int duration, Double price) {
        this.name = name;
        this.duration = duration;
        this.price = price;
    }


    public TrainingPlan(String name, int duration, Double price, String trainerId) {
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.trainerId = trainerId;
    }

    public TrainingPlan() {
    }

    public TrainingPlan(String id, String name, int duration, Double price, List<String> commentIds, List<String> userIds, List<String> trainingDays, String trainerId) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.price = price;
        this.commentIds = commentIds;
        this.userIds = userIds;
        this.trainingDays = trainingDays;
        this.trainerId = trainerId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<String> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<String> commentIds) {
        this.commentIds = commentIds;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public List<String> getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(List<String> trainingDays) {
        this.trainingDays = trainingDays;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    @Override
    public int compareTo(TrainingPlan trainingPlan) {

        if(trainingPlan.getUserIds().size() > this.getUserIds().size()){
            return -1;
        }
        else return 1;
    }
}
