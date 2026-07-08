package com.educator.core.course.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DisplayNameCourseDto {

    private Long id;

    private String displayName;

    boolean accessToModifyCourse;

}
