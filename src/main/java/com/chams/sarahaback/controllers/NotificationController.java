package com.chams.sarahaback.controllers;

import com.chams.sarahaback.Services.NotificationService;
import com.chams.sarahaback.dto.NotificationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    @GetMapping("/{user-id}")
    public ResponseEntity<List<NotificationDto>> findAllNotificationByUser(@PathVariable("user-id") Integer userId){
        return ResponseEntity.ok(service.findAllNotificationBuUser(userId));
    }
}
