package com.moviebase.moviebaseapi.app.rest.controllers;

import com.moviebase.moviebaseapi.app.util.exception.AppException;
import com.moviebase.moviebaseapi.app.rest.model.ApiError;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.UUID;

@Log4j2
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        ApiError apiError = new ApiError(logException(ex), HttpStatus.BAD_REQUEST, "Validation error", ex);
        apiError.addValidationErrors(result.getFieldErrors());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(apiError);
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiError> handle(IllegalArgumentException e) {
        ApiError apiError = new ApiError(logException(e), HttpStatus.BAD_REQUEST, e.getMessage(), e);
        return ResponseEntity.badRequest().body(apiError);
    }

    @ResponseBody
    @ExceptionHandler(AppException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handle(AppException e) {
        ApiError apiError = new ApiError(logException(e), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiError);
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ApiError> handle(Exception e) {
        ApiError apiError = new ApiError(logException(e), HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(apiError);
    }

    private String logException(Throwable throwable){
        String errorId = UUID.randomUUID().toString();
        log.error(String.format("%s, errorId: %s, ex: ", throwable.getClass().getName(), errorId), throwable);
        return errorId;
    }
}
