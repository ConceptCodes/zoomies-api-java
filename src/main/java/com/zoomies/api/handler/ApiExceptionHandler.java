package com.zoomies.api.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zoomies.api.exceptions.NotFoundException;
import com.zoomies.api.model.Response;
import com.zoomies.api.util.ResponseUtil;

import jakarta.validation.ValidationException;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        return ResponseUtil.error(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Response<String>> handleValidationException(ValidationException ex) {
        return ResponseUtil.error(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> handleGenericException(Exception ex) {
        return ResponseUtil.error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
