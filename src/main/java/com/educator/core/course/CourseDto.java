package com.educator.core.course;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
public class CourseDto {

    private Long id;

    @NotBlank
    @Size(max = 25)
    private String displayName;

}
