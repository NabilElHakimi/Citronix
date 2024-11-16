package me.elhakimi.citronix.rest.exception;

public class mustBeNullException extends RuntimeException {
    public mustBeNullException(String fieldName) {
        super("The field "+ fieldName+ " must be null.");
    }
}
