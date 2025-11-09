package com.educator.core.subject.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class SubjectDto {

    private Long id;

    @NotBlank
    private String displayName;

    @NotNull
    private Long courseId;
}
