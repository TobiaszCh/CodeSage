package com.educator.core.subject.dto;

import com.educator.core.subject.SubjectColor;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CheckCompletedSessionsDto {

    private Long id;

    private Long answerSessionId;

    private SubjectColor subjectColor;


}
