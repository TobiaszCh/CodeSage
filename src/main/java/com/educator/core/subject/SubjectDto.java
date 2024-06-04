package com.educator.core.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SubjectDto {

    private Long id;
    private String displayName;
    private Long courseId;

}
