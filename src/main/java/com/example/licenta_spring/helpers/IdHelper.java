package com.example.licenta_spring.helpers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class IdHelper {

    @Id
    private String id;

    private String idHelper;

    public IdHelper(String idHelper) {
        this.idHelper = idHelper;
    }

    public IdHelper() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHelper() {
        return idHelper;
    }

    public void setIdHelper(String idHelper) {
        this.idHelper = idHelper;
    }
}
