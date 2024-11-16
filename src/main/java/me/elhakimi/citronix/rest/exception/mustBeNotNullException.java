package me.elhakimi.citronix.rest.exception;

public class mustBeNotNullException extends RuntimeException {
    public mustBeNotNullException(String fieldName) {
        super("The field "+ fieldName+ " must be not null.");
    }
}
