package me.elhakimi.citronix.rest.exception;

import me.elhakimi.citronix.rest.exception.farm.FieldMustBeNullException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.annotation.Annotation;

@RestControllerAdvice
public class ExceptionsHandlers extends RuntimeException {

    @ExceptionHandler(FieldMustBeNullException.class)
    public ResponseEntity<String> handleFieldMustBeNullException(FieldMustBeNullException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
