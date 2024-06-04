package com.educator.controller;
import com.educator.core.course.CourseDto;
import com.educator.core.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {
    @Autowired
    private final CourseService courseService;

    @GetMapping(value = "/search/{id}")
    public CourseDto getCoursesId(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @GetMapping
    public List<CourseDto> getCoursesAll() {
        return courseService.getAllCourses();
    }

    @GetMapping("/phrase/{phrase}")
    public List<CourseDto> getCoursesWithWord(@PathVariable String phrase) {
        return courseService.getWithPhrase(phrase);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCourseId(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }

    @PostMapping
    public void createCourse(@RequestBody CourseDto courseDto) {
        courseService.createCourse(courseDto);
    }

}
