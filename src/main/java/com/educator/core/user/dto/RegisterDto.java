package com.educator.core.user.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
public class RegisterDto {
    @NotBlank
    @Pattern(regexp = "^[0-9A-Za-z_-]+$"
            , message = "Login może zawierać tylko litery, cyfry, myślnik i podłogę bez znaków diakrytycznych.")
    private String username;
    @NotBlank
    @Size(min = 8, max = 14, message = ("Hasło musi mieć od 8 do 14 znaków"))
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$"
            , message = "Hasło musi zawierać przynajmniej 1 dużą literę i znak specjalny.")
    private String password;
    @NotBlank
    private String repeatedPassword;

}
