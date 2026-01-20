package com.study.attend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateStudyNameException.class)
    public ResponseEntity<String> handleDuplicateStudyName(DuplicateStudyNameException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
