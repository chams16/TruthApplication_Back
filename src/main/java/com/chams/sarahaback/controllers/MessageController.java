package com.chams.sarahaback.controllers;

import com.chams.sarahaback.Services.MessageService;
import com.chams.sarahaback.dto.MessageDto;
import com.chams.sarahaback.models.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService service;

    @PostMapping("/")
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto message){
            return ResponseEntity.ok(service.save(message));
    }

    @GetMapping("/sent/{user-id}")
    public ResponseEntity<List<MessageDto>> findAllSentMessageByUser(
            @PathVariable(name = "user-id") Integer userId){
        return ResponseEntity.ok(service.findAllSentMessageByUser(userId));
    }

    @GetMapping("/received/{user-id}")
    public ResponseEntity<List<MessageDto>> findAllReceivedMessageByUser(
            @PathVariable(name = "user-id") Integer userId){
        return ResponseEntity.ok(service.findAllReceivedMessageByUser(userId));
    }

    @PatchMapping("/publish/{id-message}")
    public ResponseEntity<MessageDto> publishMessage(
            @PathVariable(name = "id-message") Integer idMessage) {
        return ResponseEntity.ok(service.publishMessage(idMessage));
    }

    @PatchMapping("/unpublish/{id-message}")
    public ResponseEntity<MessageDto> unPublishMessage(
            @PathVariable(name = "id-message")Integer idMessage) {
        return ResponseEntity.ok(service.unPublishMessage(idMessage));
    }

    @PatchMapping("/mark/{id-message}")
    public ResponseEntity<MessageDto> markAsFavorite(
            @PathVariable(name = "id-message")Integer idMessage) {
        return ResponseEntity.ok(service.markAsFavorite(idMessage));
    }

    @PatchMapping("/unmark/{id-message}")
    public ResponseEntity<MessageDto> unmarkAsFavorite(
            @PathVariable(name = "id-message")Integer idMessage) {
        return ResponseEntity.ok(service.unmarkAsFavorite(idMessage));
    }


}
