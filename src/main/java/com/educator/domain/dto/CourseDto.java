package com.educator.domain.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CourseDto {

    private final Long id;
    private final String displayName;
}
