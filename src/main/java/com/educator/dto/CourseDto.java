package com.educator.dto;

import com.educator.domain.Basic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String displayName;
    private List<Basic> basics;

}
