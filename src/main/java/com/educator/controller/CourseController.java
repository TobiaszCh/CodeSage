package com.educator.controller;
import com.educator.core.course.CourseDto;
import com.educator.core.course.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@CrossOrigin(origins = {"http://localhost:4200", "https://code-sage-front-a970cdb2bc71.herokuapp.com"}, allowCredentials = "true")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<CourseDto> getAllCourses() {
        return courseService.getAllMyCourses();
    }

    @GetMapping("/search/{phrase}")
    public List<CourseDto> getCoursesByPhrase(@PathVariable String phrase) {
        return courseService.getWithPhrase(phrase);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }

    @PostMapping
    public void createCourse(@Valid @RequestBody CourseDto courseDto) {
        courseService.createMyCourse(courseDto);
    }

    @PatchMapping("/{id}")
    public void updateCourse(@PathVariable Long id, @Valid @RequestBody CourseDto courseDto) {
        courseService.updateCourse(id, courseDto);
    }
}
