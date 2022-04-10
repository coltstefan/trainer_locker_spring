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
public class TrainingDay {

    @Id
    private String id;
    private String name;
    private List<String> exerciseSetIds = new ArrayList<String>();

    public TrainingDay() {
    }

    public TrainingDay(String name, List<String> exerciseSetIds) {
        this.name = name;
        this.exerciseSetIds = exerciseSetIds;
    }

    public TrainingDay(String name) {
        this.name = name;
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

    public List<String> getExerciseSetIds() {
        return exerciseSetIds;
    }

    public void setExerciseSetIds(List<String> exerciseSetIds) {
        this.exerciseSetIds = exerciseSetIds;
    }
}
