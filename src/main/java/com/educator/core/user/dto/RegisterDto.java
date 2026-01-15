package com.educator.core.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class RegisterDto {

    @NotBlank
    @Email(message = "It isn't email")
    private String username;

    @NotBlank
    @Size(min = 8, max = 100, message = "Hasło musi mieć od 8 do 100 znaków")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$"
            , message = "Hasło musi zawierać przynajmniej 1 dużą literę i znak specjalny.")
    private String password;

    @NotBlank
    private String repeatedPassword;

}
