package com.example.licenta_spring.domains;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Payment {

    @Id
    String id;

    private String userId;
    private String trainerId;
    private String trainingPlanId;

    private double payment;

    private int yearCreated = LocalDateTime.now().getYear();
    private String monthCreated = String.valueOf(LocalDateTime.now().getMonth());
    private int dayCreated = LocalDateTime.now().getDayOfMonth();

    public Payment() {
    }

    public Payment(String userId, String trainderId, String trainingPlanId, double payment) {
        this.userId = userId;
        this.trainerId = trainderId;
        this.trainingPlanId = trainingPlanId;
        this.payment = payment;
    }
}
