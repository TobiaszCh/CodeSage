package com.educator.aspect;

import com.educator.core.course.dto.CourseDto;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class CourseVisibilityAccessAspect {

    private final ServiceAccess serviceAccess;

    @Before("@annotation(courseFunctionAccess) && args(*, courseDto,..)")
    public void beforeUpdate(CourseVisibilityAccess courseVisibilityAccess, CourseDto courseDto) {
        serviceAccess.checkVisibility(courseDto);
    }

    @Before("@annotation(courseFunctionAccess) && args(courseDto,..)")
    public void beforeCreate(CourseVisibilityAccess courseVisibilityAccess, CourseDto courseDto) {
        serviceAccess.checkVisibility(courseDto);
    }

}
