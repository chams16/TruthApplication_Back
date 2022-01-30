package com.chams.sarahaback.Services;

import com.chams.sarahaback.Exceptions.ObjectValidationException;
import com.chams.sarahaback.dto.MessageDto;
import com.chams.sarahaback.mappers.ObjectMapper;
import com.chams.sarahaback.models.Message;
import com.chams.sarahaback.models.Notification;
import com.chams.sarahaback.models.User;
import com.chams.sarahaback.repository.MessageRepository;
import com.chams.sarahaback.repository.NotificationRepository;
import com.chams.sarahaback.validators.ObjectValidator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class MessageService {

    private final MessageRepository messageRepository;
    private final NotificationRepository notificationRepository;
    private final ObjectValidator<MessageDto> validator;
    private final ObjectMapper mapper;

    public MessageDto save(MessageDto message){
        validator.validate(message);
        if (Objects.equals(message.getSenderId(), message.getReceiverId())){
            throw new ObjectValidationException
                    (Set.of("you cannot send a message to your self"),this.getClass().getName());
        }
        Message messageToSave = mapper.toMessage(message);
        messageToSave.setCreatedDate(LocalDateTime.now());
        Message savedMessage = messageRepository.save(messageToSave);
        creatandsaveNotification(message.getReceiverId());
        return mapper.tomessageDto(savedMessage);
    }

    public List<MessageDto> findAllSentMessageByUser(Integer userId){
        return messageRepository.findAllBySenderId(userId)
                .stream().map
                        (mapper::tomessageDto)
                .collect(Collectors.toList());
    }

    public List<MessageDto> findAllReceivedMessageByUser(Integer userId){
        return messageRepository.findAllByReceiverId(userId)
                .stream().map
                        (mapper::tomessageDto)
                .collect(Collectors.toList());
    }

    public MessageDto publishMessage(Integer idMessage) {
        Message message = messageRepository.findById(idMessage)
                .orElseThrow(EntityNotFoundException::new);
        message.setPublicMsg(true);
        Message savedMessage = messageRepository.save(message);
        return mapper.tomessageDto(savedMessage);
    }

    public MessageDto unPublishMessage(Integer idMessage) {
        Message message = messageRepository.findById(idMessage)
                .orElseThrow(()-> new EntityNotFoundException());
        message.setPublicMsg(false);
        Message savedMessage = messageRepository.save(message);
        return mapper.tomessageDto(savedMessage);
    }

    public MessageDto markAsFavorite(Integer idMessage) {
        Message message = messageRepository.findById(idMessage)
                .orElseThrow(()-> new EntityNotFoundException());
        message.setFavori(true);
        Message savedMessage = messageRepository.save(message);
        return mapper.tomessageDto(savedMessage);
    }

    public MessageDto unmarkAsFavorite(Integer idMessage) {
        Message message = messageRepository.findById(idMessage)
                .orElseThrow(()-> new EntityNotFoundException());
        message.setFavori(false);
        Message savedMessage = messageRepository.save(message);
        return mapper.tomessageDto(savedMessage);
    }

    private void creatandsaveNotification(Integer idReceiver){
        if (idReceiver==null){
            return;
        }
        Notification notification = Notification.builder()
                .notification("You Received a new message at " + LocalDateTime.now())
                .createdDate(LocalDateTime.now())
                .consulted(false)
                .user(User.builder()
                        .id(idReceiver)
                        .build())
                .build();
        notificationRepository.save(notification);
    }




}
