package com.chams.sarahaback.Exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExceptionRepresentation {

    private String errorMessage;

    private String errorSource;

    private Set<String> validationErrors;
}
