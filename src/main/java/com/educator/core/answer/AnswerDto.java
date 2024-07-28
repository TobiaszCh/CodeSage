package com.educator.core.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class AnswerDto {

    private  Long id;

    private  String displayName;

    private boolean isCorrect;

    private Long questionId;

    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }
}
