package com.chams.sarahaback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationDto implements Serializable {
    private Integer id;

    private String notification;

    private boolean consulted;

    private LocalDateTime createdDate;
}
