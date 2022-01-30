package com.chams.sarahaback.Services;

import com.chams.sarahaback.dto.NotificationDto;
import com.chams.sarahaback.mappers.ObjectMapper;
import com.chams.sarahaback.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository repository;
    private final ObjectMapper mapper;

    public List<NotificationDto> findAllNotificationBuUser(Integer userId){
        return repository.findAllByUserId(userId).stream()
                .map(mapper::toNotificationDto)
                .collect(Collectors.toList());
    }
}
