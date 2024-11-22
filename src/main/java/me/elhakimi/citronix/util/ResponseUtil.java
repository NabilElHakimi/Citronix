package me.elhakimi.citronix.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Object> deleteSuccessfully(String name) {
        return createResponse(name + " deleted successfully.", HttpStatus.OK, null);
    }

    public static ResponseEntity<Object> updateSuccessfully(String name, Object updatedObject) {
        return createResponse(name + " updated successfully.", HttpStatus.OK, updatedObject);
    }

    public static ResponseEntity<Object> saveSuccessfully(String name, Object savedObject) {
        return createResponse(name + " saved successfully.", HttpStatus.CREATED, savedObject);
    }

    public static ResponseEntity<Object> saveFailed(String name) {
        return createResponse(name + " failed to save.", HttpStatus.BAD_REQUEST, null);
    }

    public static ResponseEntity<Object> notFound(String name) {
        return createResponse(name + " not found.", HttpStatus.NOT_FOUND, null);
    }

    public static ResponseEntity<Object> getSuccessfully(String name, Object object) {
        return createResponse(name + " retrieved successfully.", HttpStatus.OK , object);
    }

    public static ResponseEntity<Object> mustBeNullException(String name) {
        return createResponse(name + " must be null.", HttpStatus.BAD_REQUEST, null);
    }

    public static ResponseEntity<Object> mustBeNotNullException(String name) {
        return createResponse(name + " must be Not null.", HttpStatus.BAD_REQUEST, null);
    }

    private static ResponseEntity<Object> createResponse(String message, HttpStatus status, Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put("message", message);
        if (data != null) {
            response.put("data", data);
        }
        return new ResponseEntity<>(response, status);
    }
}
