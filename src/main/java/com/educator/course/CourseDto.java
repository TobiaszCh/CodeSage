package com.educator.course;
import com.educator.subject.Subject;
import com.educator.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class CourseDto {
    private Long id;
    private String displayName;

}
