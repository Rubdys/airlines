package com.example.airport_backend.exception;

import lombok.Getter;

@Getter
public enum ApplicationError {
    WRONG_PASSWORD("Incorrect password", 400, "PENNE - 007"),
    NOT_FOUND("Not found", 400, "SPAGHETTI - 001"),
    MISSING_FIELDS("Missing fields. Cant add to database", 400, "MARGHERITA - 002");

    private String messageTemplate;
    private int httpStatus;
    private String internalErrorCode;

    ApplicationError(String messageTemplate, int httpStatus, String internalErrorCode) {
        this.messageTemplate = messageTemplate;
        this.httpStatus = httpStatus;
        this.internalErrorCode = internalErrorCode;
    }


}
