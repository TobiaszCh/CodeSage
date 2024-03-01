package com.educator.answer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private Long id;

    private String displayName;

    private boolean isCorrect;

    private Long questionId;
}
