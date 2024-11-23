package me.elhakimi.citronix.rest.exception.exceptions;

public class YouCantAddMoreTreesToThisField extends RuntimeException {
    public YouCantAddMoreTreesToThisField(){
        super("You can't add more trees to this field");
    }
}
