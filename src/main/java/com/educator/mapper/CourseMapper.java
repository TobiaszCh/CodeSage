package com.educator.mapper;

import com.educator.domain.Course;
import com.educator.dto.CourseDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourseMapper {

    public CourseDto mapToDtoCourse(Course course) {
        return new CourseDto (
                course.getId(),
                course.getDisplayName());
    }

    public Course mapToCourse(CourseDto courseDto) {
        return new Course(
                courseDto.getId(),
                courseDto.getDisplayName());
    }

    public List<CourseDto> mapToListDtoCourse(List<Course> course) {
        return course.stream().map(this::mapToDtoCourse).collect(Collectors.toList());
    }
}
