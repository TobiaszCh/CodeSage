package com.educator.core.course;

import com.educator.core.course.dto.CourseDto;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    public CourseDto mapToDtoCourse(Course course) {
        return new CourseDto(
                course.getId(),
                course.getDisplayName(),
                course.getDescription(),
                course.getImageUrl(),
                course.getVisibility()
        );
    }

    public Course mapToCourse(CourseDto courseDto, User ownerCourse) {
        return Course.builder()
                .id(courseDto.getId())
                .displayName(courseDto.getDisplayName())
                .description(courseDto.getDescription())
                .visibility(courseDto.getVisibility())
                .owner(ownerCourse)
                .build();
    }

}
