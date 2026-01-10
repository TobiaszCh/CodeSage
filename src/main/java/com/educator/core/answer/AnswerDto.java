package com.educator.core.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private Long id;

    @NotBlank(message = "Odpowiedź nie może być pusta")
    private String displayName;

    private boolean isCorrect;

    private Long questionId;

    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }
}
