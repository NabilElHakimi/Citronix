package me.elhakimi.citronix.rest.exception.exceptions;

public class TheTreeAgeIsMoreThan20Years extends RuntimeException {
    public TheTreeAgeIsMoreThan20Years() {
        super("The tree age is more than 20 years");
    }
}
