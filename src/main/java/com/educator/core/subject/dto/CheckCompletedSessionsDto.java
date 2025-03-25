package com.educator.core.subject.dto;

import com.educator.core.subject.SubjectCompletedAge;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@ToString
@AllArgsConstructor
public class CheckCompletedSessionsDto {

    private Long id;
    @NotNull
    private Long answerSessionId;
    @NotNull
    private SubjectCompletedAge subjectCompletedAge;


}
