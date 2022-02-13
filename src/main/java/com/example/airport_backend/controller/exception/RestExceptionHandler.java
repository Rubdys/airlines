package com.example.airport_backend.controller.exception;

import com.example.airport_backend.exception.ApplicationErrorResponse;
import com.example.airport_backend.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApplicationErrorResponse> handleGlobal(Exception e){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApplicationErrorResponse.builder()
                        .errorMessage("Unknown error")
                        .exceptionTime(LocalDateTime.now())
                        .internalErrorCode("UNK - 001")
                        .build());
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ApplicationErrorResponse> handleApplicationException(ApplicationException err){
        return ResponseEntity.status(err.getErrorStatus())
                .body(ApplicationErrorResponse.builder()
                        .errorMessage(err.getMessage())
                        .exceptionTime(err.getExceptionTime())
                        .internalErrorCode(err.getInternalErrorCode())
                        .build());
    }

}
