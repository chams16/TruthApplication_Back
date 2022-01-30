package com.chams.sarahaback.Services;

import com.chams.sarahaback.dto.UserDto;
import com.chams.sarahaback.mappers.ObjectMapper;
import com.chams.sarahaback.models.User;
import com.chams.sarahaback.repository.UserRepository;
import com.chams.sarahaback.validators.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ObjectValidator<UserDto> validator;
    private final ObjectMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public UserDto save(UserDto userDto){
        validator.validate(userDto);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User userToSave = mapper.toUser(userDto);
        if (userDto.getId()==null){
            String generatedUserName = generateUserName(userDto.getFirstName(),userDto.getLastName());
            userToSave.setUserName(generatedUserName);
        }
        User savedUser = userRepository.save(userToSave);
        return mapper.toUserDto(savedUser);
    }

    private String generateUserName(String firstName,String lastName){
        return firstName+"-"+lastName+new Random().nextInt(1000);

    }
}
