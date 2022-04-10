package com.example.licenta_spring;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class ResponseDecorator<T>{

    private List<T> listOfElements = new ArrayList<>();



    public void responseDecorator(List<T> listOfElements) {
        this.listOfElements = listOfElements;
    }

    public String getResponse(List<T> listOfElements) {

        String response = "";

        for(int i = 0; i<listOfElements.size();i++){
            response = response + "," + listOfElements.get(0);
        }
        return response;

    }
}
