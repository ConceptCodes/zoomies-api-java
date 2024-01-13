package com.zoomies.api.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.zoomies.api.model.Response;

public class ResponseUtil {
    public static ResponseEntity success(Object data) {
        Response<Object> response = new Response<>();
        response.setSuccess(true);
        response.setMessage("Success");
        response.setData(data);
        return ResponseEntity.ok().body(data);
    }

    public static ResponseEntity error(HttpStatus status, String message) {
        Response<String> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(message);
        response.setData(null);
        return ResponseEntity.status(status).body(response);
    }
}
