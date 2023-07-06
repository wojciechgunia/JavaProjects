package com.example.kurs;

public class FamilyLenghtException extends RuntimeException{

    public FamilyLenghtException(String message) {
        super(message);
    }

    public FamilyLenghtException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilyLenghtException(Throwable cause) {
        super(cause);
    }
}
