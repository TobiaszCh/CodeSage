package com.educator.core.answer_session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionAnswerSelectDto {

    private Long id;

    private Long questionId;

    private Long answerId;

}
