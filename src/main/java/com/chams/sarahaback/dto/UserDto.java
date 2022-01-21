package com.chams.sarahaback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Integer id;

    private String userName;

    private String firstName;

    private String lastName;

    private LocalDateTime birthDate;

    private String email;

    private String password;
}
