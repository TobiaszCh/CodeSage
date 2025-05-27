package com.educator.core.user.dto;

import lombok.Getter;

import javax.validation.constraints.*;

@Getter
public class RegisterDto {

    @Pattern(regexp = "^[A-Za-z_-]+$"
            , message = "Login musi mieć przynajmniej 1 dużą literę i znak specjalny")
    private String username;
    @Size(min = 8, max = 14, message = ("Hasło musi mieć od 8 do 14 znaków"))
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$"
            , message = "Hasło musi zawierać przynajmniej 1 dużą literę i znak specjalny")
    private String password;

    private String repeatedPassword;

}
