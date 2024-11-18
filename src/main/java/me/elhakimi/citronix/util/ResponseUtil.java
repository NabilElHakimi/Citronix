package me.elhakimi.citronix.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static ResponseEntity<Object> deleteSuccessfully(String name) {
        return createResponse(name + " deleted successfully.", HttpStatus.OK);
    }

    public static ResponseEntity<Object> saveFailed(String name) {
        return createResponse(name + " failed to save.", HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Object> updateSuccessfully(String name) {
        return createResponse(name + " updated successfully.", HttpStatus.OK);
    }

    public static ResponseEntity<Object> saveSuccessfully(String name) {
        return createResponse(name + " saved successfully.", HttpStatus.CREATED);
    }

    public static ResponseEntity<Object> notFound(String name) {
        return createResponse(name + " not found.", HttpStatus.NOT_FOUND);
    }

    private static ResponseEntity<Object> createResponse(String message, HttpStatus status) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put("message", message);
        return new ResponseEntity<>(response, status);
    }


}
