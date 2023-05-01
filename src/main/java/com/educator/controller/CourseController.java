package com.educator.controller;
<<<<<<< Updated upstream
import com.educator.domain.dto.CourseDto;
import com.educator.mapper.CourseMapper;
import com.educator.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

=======

import com.educator.dto.CourseDto;
import com.educator.mapper.CourseMapper;
import com.educator.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
>>>>>>> Stashed changes
import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
<<<<<<< Updated upstream
    final private CourseService courseService;
    final private CourseMapper courseMapper;

    @GetMapping(value = "{Id}")
    public CourseDto getCoursesId(@PathVariable Long Id) {
        return courseMapper.mapToDtoCourse(courseService.getCourse(Id));
=======
    private final CourseService courseService;

    private final CourseMapper courseMapper;

    @GetMapping(value = "/search/{id}")
    public CourseDto getCoursesId(@PathVariable Long id) {
        return courseMapper.mapToDtoCourse(courseService.getCourse(id));
>>>>>>> Stashed changes
    }
    @GetMapping
    public List<CourseDto> getCoursesAll() {
        return courseMapper.mapToListDtoCourse(courseService.getAllCourses());
    }

    @GetMapping(value = "/phrase/{phrase}")
    public List<CourseDto> getCoursesWithWord(@PathVariable String phrase) {
        return courseMapper.mapToListDtoCourse(courseService.getWithPhrase(phrase));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteCourseId(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PostMapping
    public void createCourse(@RequestBody CourseDto courseDto) {
        courseService.createCourse(courseMapper.mapToCourse(courseDto));
    }
}
