package com.educator.core.question.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class QuestionResponseDto {

    private boolean finished;
    private QuestionWithoutAnswerCorrectDto question;

}
