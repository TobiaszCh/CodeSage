package com.educator.core.answer_session.dto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class AnswerSessionDto {

    private Long id;

    private int allAnswers;

    private int correctAnswers;

    private LocalDate sessionStartDate;

    private StatusAnswerSession statusAnswerSession;

    private Long userId;

    private Long subjectId;

}
