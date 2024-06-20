package com.trevis.startup.javaproject.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.trevis.startup.javaproject.exception.AppResponseException;

@ControllerAdvice
public class ExceptionHandlingController {
    

    @ExceptionHandler(value = AppResponseException.class)
    public ResponseEntity<Object> errorResponse(AppResponseException ex, WebRequest request) {

        return ResponseEntity.status(ex.getStatusCode()).body(new MessageRecord(ex.getMessage()));
    }


    private record MessageRecord(String message) {}
}
