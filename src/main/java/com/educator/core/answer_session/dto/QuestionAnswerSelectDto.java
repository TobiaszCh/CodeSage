package com.educator.core.answer_session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class QuestionAnswerSelectDto {

    @NotNull
    private Long questionId;

    @NotNull
    private Long answerId;

}
