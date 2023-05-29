package com.educator.course;
import com.educator.subject.Subject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String displayName;
    private List<Subject> subjects;

}
