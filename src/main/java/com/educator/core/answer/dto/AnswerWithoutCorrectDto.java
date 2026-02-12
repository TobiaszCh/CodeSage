package com.educator.core.answer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerWithoutCorrectDto {

    private Long id;

    @NotBlank(message = "Odpowiedź nie może być pusta")
    private String displayName;

    private Long questionId;

}
