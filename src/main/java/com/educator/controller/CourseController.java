package com.educator.controller;

import com.educator.aspect.AccessPolicy;
import com.educator.aspect.CourseAccess;
import com.educator.aspect.EntityType;
import com.educator.core.course.CourseService;
import com.educator.core.course.dto.CourseDto;
import com.educator.core.course.dto.DisplayNameCourseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://code-sage-front-a970cdb2bc71.herokuapp.com",
        "https://www.codesage.pl"
}, allowCredentials = "true")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/{id}")
    @CourseAccess(
            idEntityType = EntityType.COURSE,
            idExpression = "#id",
            accessPolicy = AccessPolicy.LEARN
    )
    public CourseDto getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping
    public List<DisplayNameCourseDto> getAllCourses() {
        return courseService.getAllCourses();
    }

    @DeleteMapping("/{id}")
    @CourseAccess(
            idEntityType = EntityType.COURSE,
            idExpression = "#id",
            accessPolicy = AccessPolicy.MANAGE
    )
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }

    @PostMapping
    public Long createCourse(@Valid @RequestPart CourseDto courseDto, @RequestPart MultipartFile file) {
        return courseService.createCourse(courseDto, file);
    }

    @PatchMapping("/{id}")
    @CourseAccess(
            idEntityType = EntityType.COURSE,
            idExpression = "#id",
            accessPolicy = AccessPolicy.MANAGE
    )
    public Long updateCourse(@PathVariable Long id, @Valid @RequestPart CourseDto courseDto, @RequestPart MultipartFile file) {
        return courseService.updateCourse(id, courseDto, file);
    }

}
