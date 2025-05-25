package com.educator.core.user;

import lombok.Getter;

@Getter
public class RegisterDto {

    private String username;

    private String password;

    private String repeatPassword;
}
