package com.educator.core.course;

import com.educator.core.course.dto.CourseDto;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CourseMapper {

    public CourseDto mapToDtoCourse(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .displayName(course.getDisplayName())
                .description(course.getDescription())
                .imageUrl(course.getImageUrl())
                .visibility(course.getVisibility())
                .owner(course.getOwner())
                .build();
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
