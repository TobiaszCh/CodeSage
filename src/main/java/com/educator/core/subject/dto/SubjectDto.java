package com.educator.core.subject.dto;

import com.educator.core.subject.SubjectCompletionStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SubjectDto {

    private Long id;

    @NotBlank
    @Size(max = 50)
    private String displayName;

    @NotNull
    private Long courseId;

    private long countOfQuestionsInSubject;

    private SubjectCompletionStatus subjectCompletionStatus;

    public SubjectDto(Long id, String displayName, Long courseId) {
        this.id = id;
        this.displayName = displayName;
        this.courseId = courseId;
    }

    public SubjectDto(Long id, String displayName, Long courseId, long countOfQuestionsInSubject) {
        this.id = id;
        this.displayName = displayName;
        this.courseId = courseId;
        this.countOfQuestionsInSubject = countOfQuestionsInSubject;
    }
}
