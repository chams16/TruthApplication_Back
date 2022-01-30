package com.chams.sarahaback.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY )
public class  UserDto implements Serializable {

    private Integer id;

    private String userName;

    @NotNull(message = "you to provide the first name")
    private String firstName;

    @NotNull(message = "you need to provide the last name")
    private String lastName;

    //@NotNull(message = "you need to provide the birth date")
    //@Past(message = "the birth date should be in the past")
    //
    // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime birthDate;

    @Email(message = "you need to provide a valid email")
    private String email;

    @NotNull(message = "you need to provide the password")
    @Size(min = 8,max = 16)
    private String password;
}
