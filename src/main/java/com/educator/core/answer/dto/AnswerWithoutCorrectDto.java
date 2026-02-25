package com.educator.core.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class AnswerWithoutCorrectDto {

    private Long id;
    @Size(max = 200)
    @NotBlank(message = "Odpowiedź nie może być pusta")
    private String displayName;

    private Long questionId;

}
