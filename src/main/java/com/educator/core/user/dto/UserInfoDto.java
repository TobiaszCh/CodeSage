package com.educator.core.user.dto;

import com.educator.core.user.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserInfoDto {

    private String username;

    private Role role;

}
