package com.educator.core.course;

import com.educator.core.course.dto.CourseDto;
import com.educator.core.course.dto.DisplayNameCourseDto;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    public CourseDto mapToDtoCourse(Course course, boolean accessToModifyCourse) {
        return new CourseDto(
                course.getId(),
                course.getDisplayName(),
                course.getDescription(),
                course.getImageUrl(),
                course.getVisibility(),
                accessToModifyCourse
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

    public DisplayNameCourseDto mapToDtoDisplayNameCourse(Course course, boolean accessToModifyCourse) {
        return new DisplayNameCourseDto(
                course.getId(),
                course.getDisplayName(),
                accessToModifyCourse
        );
    }

}
