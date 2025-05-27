package com.educator.core.user;

import com.educator.core.user.dto.RegisterDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser (RegisterDto registerDto) {
        return User.builder()
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
                .enabled(true)
                .role(Role.USER)
                .build();
    }
}
