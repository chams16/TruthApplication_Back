package com.chams.sarahaback.Exceptions;

import lombok.Getter;

import java.util.Set;

public class ObjectValidationException extends RuntimeException{

    @Getter
    private final Set<String> violations;

    @Getter
    private final String validationSource;


    public ObjectValidationException(Set<String> violations, String validationSource) {
        this.violations = violations;
        this.validationSource = validationSource;
    }
}
