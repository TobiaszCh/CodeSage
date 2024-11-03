package com.educator.core.subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class SubjectDto {

    private Long id;

    @NotNull
    private String displayName;

    @NotNull
    private Long courseId;
}
