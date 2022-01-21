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
public class MessageDto {
    private Integer id;

    private LocalDateTime createdDate;

    private String content;

    private String typeMsg;

    private boolean favori;
}
