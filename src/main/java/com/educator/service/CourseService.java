package com.educator.service;

import com.educator.domain.Course;
import com.educator.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    final private CourseRepository courseRepository;

    public Course getCourse(Long id) {
        return courseRepository.findAllById(id);
    }

    public List<Course> getWithPhrase(String phrase) {
        List<Course> courses =  courseRepository.findAll();
        List<Course> listWithPhrases = new ArrayList<>();
        for(Course course: courses) {
            if(course.getDisplayName().contains(phrase)) {
                listWithPhrases.add(course);
            }
        }
        return listWithPhrases;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void createCourse(Course course) {
        courseRepository.save(course);
    }
}
