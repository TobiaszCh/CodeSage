package com.educator.core.answer_session.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerSessionDto {

    private Long id;

    private int allAnswers;

    private int correctAnswers;

    private Long userId;

    private Long subjectId;

}
