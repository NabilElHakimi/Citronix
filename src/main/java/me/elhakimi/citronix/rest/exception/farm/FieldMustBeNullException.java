package me.elhakimi.citronix.rest.exception.farm;

public class FieldMustBeNullException extends RuntimeException {
    public FieldMustBeNullException() {
        super("The field must be null.");
    }
}
