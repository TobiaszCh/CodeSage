package com.educator.core.answer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private  Long id;

    @NotBlank(message = "Odpowiedź nie może być pusta")
    private String displayName;

    private boolean isCorrect;

    private Long questionId;

    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }
}
