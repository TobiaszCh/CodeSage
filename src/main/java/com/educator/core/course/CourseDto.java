package com.educator.core.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class CourseDto {

    private Long id;
    @NotNull
    private String displayName;

}
