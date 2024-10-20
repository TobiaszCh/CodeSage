package com.educator.core.answer_session.dto;

import com.educator.core.answer_session.enums.SubjectColor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CheckCompletedSessionsDto {

    private Long id;

    private Long subjectId;

    private SubjectColor subjectColor;




}
