package com.example.licenta_spring.helpers;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class IdHelperExerciseSet {

    @Id
    private String id;

    private String exerciseSetId;

    public IdHelperExerciseSet(String exerciseSetId) {
        this.exerciseSetId = exerciseSetId;
    }

    public IdHelperExerciseSet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExerciseSetId() {
        return exerciseSetId;
    }

    public void setExerciseSetId(String exerciseSetId) {
        this.exerciseSetId = exerciseSetId;
    }
}
