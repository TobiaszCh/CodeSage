package com.educator.course_management;

import com.educator.variable_management.Variable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String displayName;
    private List<Variable> variables;

}
