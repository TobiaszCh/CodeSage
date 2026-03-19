package com.educator.core.answer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private Long id;
    @Size(max = 200)
    @NotBlank(message = "Odpowiedź nie może być pusta")
    private String displayName;

    @JsonProperty("isCorrect")
    private boolean isCorrect;

    private Long questionId;

}
