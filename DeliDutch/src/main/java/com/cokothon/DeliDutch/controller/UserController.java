package com.cokothon.DeliDutch.controller;

import com.cokothon.DeliDutch.dto.UserDto;
import com.cokothon.DeliDutch.entity.User;
import com.cokothon.DeliDutch.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/v1/signup")
    public User registerUser(@RequestBody UserDto userDto) {
        User save = userService.save(User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .dormitory(userDto.getDormitory())
                .build());
        return save;
    }
}
