package com.chams.sarahaback.validators;

import com.chams.sarahaback.Exceptions.ObjectValidationException;
import org.springframework.stereotype.Component;

import javax.validation.*;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator<T extends Serializable> {

    private final ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validate(T clazz){
        Set<ConstraintViolation<T>> violations = validator.validate(clazz);
        if(violations.size()>0){
            Set<String> errors = violations.stream()
                        .map(ConstraintViolation::getMessage).collect(Collectors.toSet());
            throw new ObjectValidationException(errors,clazz.getClass().getName());
        }
    }
}
