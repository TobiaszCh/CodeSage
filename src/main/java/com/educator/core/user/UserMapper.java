package com.educator.core.user;

import com.educator.core.user.dto.RegisterDto;
import com.educator.core.user.dto.UserProfileDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(RegisterDto registerDto, Role role) {
        return User.builder()
                .username(registerDto.getUsername())
                .password(registerDto.getPassword())
                .role(role)
                .build();
    }

    public UserProfileDto mapToUserDto(User user) {
        return new UserProfileDto(
                user.getUsername(),
                user.getRole(),
                user.getCreatedAt()
        );
    }

}
