package com.educator.core.answer_session.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectIdToAnswerSessionDto {
    @NotNull
    private Long id;
}
