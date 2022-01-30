package com.chams.sarahaback.mappers;

import com.chams.sarahaback.dto.MessageDto;
import com.chams.sarahaback.dto.NotificationDto;
import com.chams.sarahaback.dto.UserDto;
import com.chams.sarahaback.models.Message;
import com.chams.sarahaback.models.Notification;
import com.chams.sarahaback.models.User;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {

    public Message toMessage(MessageDto dto){
        if(dto==null){
            return null;
        }
        return Message.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .favori(dto.isFavori())
                .publicMsg(dto.isPublicMsg())
                .receiver(
                        User.builder()
                                .id(dto.getReceiverId())
                                .build()
                )
                .sender(
                        User.builder()
                                .id(dto.getSenderId())
                                .build()
                )
                .typeMsg(dto.getTypeMsg())
                .build();
    }

    public MessageDto tomessageDto(Message message){
        if(message==null){
            return null;
        }
        return MessageDto.builder()
                .id(message.getId())
                .content(message.getContent())
                .publicMsg(message.isPublicMsg())
                .favori(message.isFavori())
                .typeMsg(message.getTypeMsg())
                .createdDate(message.getCreatedDate())
                .senderId(message.getSender().getId())
                .receiverId(message.getReceiver().getId())
                .build();
    }

    public User toUser(UserDto userDto) {
        if(userDto==null){
            return null;
        }
        return User.builder()
                .id(userDto.getId())
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .birthDate(userDto.getBirthDate())
                .userName(userDto.getUserName())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .build();
    }

    public UserDto toUserDto(User user) {
        if(user==null){
            return null;
        }
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .birthDate(user.getBirthDate())
                .userName(user.getUserName())
                .email(user.getEmail())
                .build();
    }

    public NotificationDto toNotificationDto(Notification notification) {
        if(notification==null){
            return null;
        }
        return NotificationDto.builder()
                .id(notification.getId())
                .notification(notification.getNotification())
                .createdDate(notification.getCreatedDate())
                .consulted(notification.isConsulted())
                .build();
    }

}
