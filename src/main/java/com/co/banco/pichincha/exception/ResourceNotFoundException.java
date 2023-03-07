package com.co.banco.pichincha.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(final String message) {
        super(message);
    }
}
