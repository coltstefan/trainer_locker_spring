package com.example.licenta_spring.domains;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Comment {

    @Id
    private String id;

    private String comment;
    private String trainingPlanId;
    private String userId;
    private String lastName;
    private String firstName;
    private int yearCreated = LocalDateTime.now().getYear();
    private String monthCreated = String.valueOf(LocalDateTime.now().getMonth());
    private int dayCreated = LocalDateTime.now().getDayOfMonth();

    public Comment() {
    }

    public Comment(String comment, String trainingPlanId, String userId) {
        this.comment = comment;
        this.trainingPlanId = trainingPlanId;
        this.userId = userId;
    }

    public Comment(String comment, String trainingPlanId, String userId, String lastName, String firstName) {
        this.comment = comment;
        this.trainingPlanId = trainingPlanId;
        this.userId = userId;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTrainingPlanId() {
        return trainingPlanId;
    }

    public void setTrainingPlanId(String trainingPlanId) {
        this.trainingPlanId = trainingPlanId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    public String getMonthCreated() {
        return monthCreated;
    }

    public void setMonthCreated(String monthCreated) {
        this.monthCreated = monthCreated;
    }

    public int getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(int dayCreated) {
        this.dayCreated = dayCreated;
    }
}
