package com.example.licenta_spring.domains;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ProgressiveOverload {

    @Id
    private String id;

    private String userId;

    private String exerciseId;

    private int weight;

    private int reps;

    private int sets;

    public ProgressiveOverload() {
    }

    public ProgressiveOverload(String userId, String exerciseId, int weight, int reps, int sets) {
        this.userId = userId;
        this.exerciseId = exerciseId;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }

    public ProgressiveOverload(String id, String userId, String exerciseId, int weight, int reps, int sets) {
        this.id = id;
        this.userId = userId;
        this.exerciseId = exerciseId;
        this.weight = weight;
        this.reps = reps;
        this.sets = sets;
    }
}
