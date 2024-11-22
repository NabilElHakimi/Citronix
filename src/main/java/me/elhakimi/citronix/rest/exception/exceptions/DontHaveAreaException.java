package me.elhakimi.citronix.rest.exception.exceptions;

public class DontHaveAreaException extends RuntimeException {
    public DontHaveAreaException(String name) {
        super("You don't have space to add more "+ name +" !!");
    }
}
