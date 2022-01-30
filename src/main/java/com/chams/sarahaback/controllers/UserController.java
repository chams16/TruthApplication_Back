package com.chams.sarahaback.controllers;

import com.chams.sarahaback.Services.UserService;
import com.chams.sarahaback.Services.auth.AppUserDetailService;
import com.chams.sarahaback.dto.AuthenticationRequest;
import com.chams.sarahaback.dto.AuthenticationResponse;
import com.chams.sarahaback.dto.UserDto;
import com.chams.sarahaback.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final AuthenticationManager authenticationManager;
    private  final AppUserDetailService userDetailService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserDto> save(@RequestBody UserDto user){
        return ResponseEntity.ok(service.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                        )
        );
        final UserDetails userDetails = userDetailService.loadUserByUsername(request.getEmail());
        final String jwt = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(
                AuthenticationResponse.builder()
                        .token(jwt)
                        .build()
        );
    }


}
