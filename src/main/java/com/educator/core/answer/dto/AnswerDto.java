package com.educator.core.answer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private Long id;

    @NotBlank(message = "Odpowiedź nie może być pusta")
    private String displayName;

    @JsonProperty("isCorrect")
    private boolean isCorrect;

    private Long questionId;

}
