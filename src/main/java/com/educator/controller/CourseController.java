package com.educator.controller;
import com.educator.domain.dto.CourseDto;
import com.educator.mapper.CourseMapper;
import com.educator.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    final private CourseService courseService;
    final private CourseMapper courseMapper;

    @GetMapping(value = "{Id}")
    public CourseDto getCoursesId(@PathVariable Long Id) {
        return courseMapper.mapToDtoCourse(courseService.getCourse(Id));
    }
    @GetMapping
    public List<CourseDto> getCoursesAll() {
        return courseMapper.mapToListDtoCourse(courseService.getAllCourses());
    }
}
