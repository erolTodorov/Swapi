package com.erol.swapi.error;


import java.util.UUID;

import lombok.Getter;

@Getter
public class PeopleApiException extends RuntimeException {

    private UUID id;

    PeopleApiException(String message) {
        super(message);
        this.id = UUID.randomUUID();
    }

}