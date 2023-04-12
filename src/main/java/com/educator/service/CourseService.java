package com.educator.service;

import com.educator.domain.Course;
import com.educator.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course getCourse(Long Id) {
        return courseRepository.findAllById(Id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
