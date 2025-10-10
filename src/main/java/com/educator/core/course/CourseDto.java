package com.educator.core.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
public class CourseDto {

    private Long id;

    @NotBlank
    private String displayName;

}
