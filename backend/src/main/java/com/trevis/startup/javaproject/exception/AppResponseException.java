package com.trevis.startup.javaproject.exception;

public class AppResponseException extends RuntimeException {
    
    private String message;
    private Integer statusCode;


    public AppResponseException(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public AppResponseException(String message) {
        this.message = message;
        this.statusCode = 400;
    }


    public Integer getStatusCode() {
        return statusCode;
    }
    public String getMessage() {
        return message;
    }
}
