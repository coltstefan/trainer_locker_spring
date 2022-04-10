package com.example.licenta_spring.domains;

import com.example.licenta_spring.domains.Exercise;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ExerciseSet {
    @Id
    private String id;

    private String exerciseId;
    private int sets;
    private int reps;
    private String notes;


    public ExerciseSet(String exercise, int sets, int reps, String notes) {
        this.exerciseId = exercise;
        this.sets = sets;
        this.reps = reps;
        this.notes = notes;
    }

    public ExerciseSet(int sets, int reps, String notes) {
        this.sets = sets;
        this.reps = reps;
        this.notes = notes;
    }

    public ExerciseSet(int sets, int reps) {
        this.sets = sets;
        this.reps = reps;
    }

    public ExerciseSet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExercise() {
        return exerciseId;
    }

    public void setExercise(String exercise) {
        this.exerciseId = exercise;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
