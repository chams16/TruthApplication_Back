package com.chams.sarahaback.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Message {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    private String content;

    private String typeMsg;

    private boolean favori;

    @ManyToOne
    @JoinColumn(name = "senderId")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiverId")
    private User receiver;

}
