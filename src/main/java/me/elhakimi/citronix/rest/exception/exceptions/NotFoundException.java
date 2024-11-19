package me.elhakimi.citronix.rest.exception.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super("The " + message + " not found !!");
    }
}
