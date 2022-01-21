package com.chams.sarahaback.handlers;

import com.chams.sarahaback.Exceptions.ExceptionRepresentation;
import com.chams.sarahaback.Exceptions.ObjectValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectValidationException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(ObjectValidationException exception) {
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage("Object not valid exception")
                .errorSource(exception.getValidationSource())
                .validationErrors(exception.getViolations())
                .build();
        return ResponseEntity.badRequest().body(exceptionRepresentation);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionRepresentation> handleException(){
        ExceptionRepresentation exceptionRepresentation = ExceptionRepresentation.builder()
                .errorMessage("Object not found exception")
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionRepresentation);
    }
}
