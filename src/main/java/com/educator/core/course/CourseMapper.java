package com.educator.core.course;

import com.educator.core.course.dto.CourseDto;
import com.educator.core.course.dto.DisplayNameCourseDto;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public Course mapToCourse(CourseDto courseDto, List<User> users) {
        return Course.builder()
                .id(courseDto.getId())
                .displayName(courseDto.getDisplayName())
                .description(courseDto.getDescription())
                .visibility(courseDto.getVisibility())
                .users(users)
                .build();

    }

    public DisplayNameCourseDto mapToDtoDisplayNameCourse(Course course) {
        return new DisplayNameCourseDto(
                course.getId(),
                course.getDisplayName()
        );
    }

    public List<DisplayNameCourseDto> mapToListDtoDisplayNameCourse(List<Course> course) {
        return course.stream()
                .map(this::mapToDtoDisplayNameCourse)
                .collect(Collectors.toList());
    }

}
