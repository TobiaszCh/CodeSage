package com.educator.service;

import com.educator.domain.Course;
import com.educator.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    final private CourseRepository courseRepository;

    public Course getCourse(int id) {
        return courseRepository.findAllById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
