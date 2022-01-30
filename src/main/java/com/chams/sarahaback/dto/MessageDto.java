package com.chams.sarahaback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageDto implements Serializable {
    private Integer id;

    private LocalDateTime createdDate;

    private boolean publicMsg;


    @NotNull(message = "you need to write a message")
    private String content;

    private String typeMsg;

    private boolean favori;

    private Integer senderId;

    @NotNull(message = "you need to select the receiver")
    private Integer receiverId;
}
