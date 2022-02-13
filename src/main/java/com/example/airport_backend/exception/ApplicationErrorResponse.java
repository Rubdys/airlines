package com.example.airport_backend.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ApplicationErrorResponse{

    private String errorMessage;
    private String internalErrorCode;
    private LocalDateTime exceptionTime;
}
