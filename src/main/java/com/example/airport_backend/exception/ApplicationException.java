package com.example.airport_backend.exception;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ApplicationException extends RuntimeException {

    private LocalDateTime exceptionTime;
    private int errorStatus;
    private String internalErrorCode;

    public ApplicationException(ApplicationError applicationError, Object ... messageParameters) {
        super(String.format(applicationError.getMessageTemplate(), messageParameters));
        this.exceptionTime = LocalDateTime.now();
        this.errorStatus = applicationError.getHttpStatus();
        this.internalErrorCode = applicationError.getInternalErrorCode();
    }
}
