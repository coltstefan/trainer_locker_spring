package com.example.licenta_spring.helpers;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class IdHelperTrainingDay {

    @Id
    private String id;

    private String trainingDayId;

    public IdHelperTrainingDay(String trainingDayId) {
        this.trainingDayId = trainingDayId;
    }

    public IdHelperTrainingDay() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingDayId() {
        return trainingDayId;
    }

    public void setTrainingDayId(String trainingDayId) {
        this.trainingDayId = trainingDayId;
    }
}