package com.erol.swapi.error;

import java.util.Map;

import lombok.Getter;

@Getter
public class InvalidObjectExeption extends PeopleApiException {

    private final Map<String,String> constraintViolations;

    public InvalidObjectExeption(String message,Map<String,String> constraintViolations) {
        super(message);
        this.constraintViolations = constraintViolations;
    }
    
}
