package com.tastecamp.api.exceptions;

public class RecipeTitleConflictException extends RuntimeException{

    RecipeTitleConflictException(String message) {
        super(message);
    }

}
