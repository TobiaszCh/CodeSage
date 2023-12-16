package com.educator.course;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseDto mapToDtoCourse(Course course) {
        return new CourseDto(
                course.getId(),
                course.getDisplayName());
        //toDo
        //course.getSubjects(),
        //course.getUser());
    }

    public Course mapToCourse(CourseDto courseDto) {
        return new Course(
                courseDto.getId(),
                courseDto.getDisplayName());
        //ToDo
        //courseDto.getUser(),
        //courseDto.getSubjects());
    }

    public List<CourseDto> mapToListDtoCourse(List<Course> course) {
        return course.stream()
                .map(this::mapToDtoCourse)
                .collect(Collectors.toList());
    }
}
