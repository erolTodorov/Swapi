package com.erol.swapi.error;

import lombok.Getter;

@Getter
public class MissingFileUploadException extends PeopleApiException {

    private static final String ERROR_MESSAGE = "Missing required file upload";
    private String entityClass;
    private String fileUploadKey;

    public MissingFileUploadException(String fileUploadKey, String entityClass) {
        super(ERROR_MESSAGE);
        this.fileUploadKey = fileUploadKey;
        this.entityClass = entityClass;
    }

}