package com.educator.core.user.dto;

import com.educator.core.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserProfileDto {

    private String username;

    private Role role;

    private LocalDateTime createdAt;

}
