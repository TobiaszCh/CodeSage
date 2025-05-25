package com.educator.core.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser (RegisterDto registerDto) {
        return User.builder()
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
                .build();
    }
}
