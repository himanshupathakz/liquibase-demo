package com.poc.liquibasedemo.exception;

public class EmployeeException extends RuntimeException{

    private String message;

    public EmployeeException(String message) {
        this.message = message;
    }

    public EmployeeException(String message, String message1) {
        super(message);
        this.message = message1;
    }

    public EmployeeException(String message, Throwable cause, String message1) {
        super(message, cause);
        this.message = message1;
    }

    public EmployeeException(Throwable cause, String message) {
        super(cause);
        this.message = message;
    }

    public EmployeeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String message1) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.message = message1;
    }
}
