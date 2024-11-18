package me.elhakimi.citronix.rest.exception;

public class DontHaveAreaException extends RuntimeException {
    public DontHaveAreaException() {
        super("You dont have area for add this field");
    }
}
