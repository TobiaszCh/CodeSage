package com.educator.core.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class LoginDto {
    @NotBlank(message = "Login musi posiadać wartość")
    private String username;
    @NotBlank(message = "Hasło musi posiadać wartość")
    private String password;
}
