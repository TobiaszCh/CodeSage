package com.educator.core.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class LoginDto {
    @NotBlank(message = "Login musi posiadać wartość")
    @Email(message = "To nie jest email. Proszę wpisać prawidłową formę")
    private String username;
    @NotBlank(message = "Hasło musi posiadać wartość")
    private String password;
}
