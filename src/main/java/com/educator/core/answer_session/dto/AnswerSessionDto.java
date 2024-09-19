package com.educator.core.answer_session.dto;
import com.educator.core.answer_session.StatusAnswerSession;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerSessionDto {

    private Long id;

    private int allAnswers;

    private int correctAnswers;

    private StatusAnswerSession statusAnswerSession;

    private Long userId;

    private Long subjectId;

}
