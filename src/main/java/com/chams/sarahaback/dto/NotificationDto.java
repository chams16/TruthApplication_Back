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
public class NotificationDto {
    private Integer id;

    private String notification;

    private boolean consulted;

    private LocalDateTime createdDate;
}
