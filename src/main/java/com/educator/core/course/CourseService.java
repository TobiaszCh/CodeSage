package com.educator.core.course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    final private CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    public CourseDto getCourseById(Long id) {
        return courseMapper.mapToDtoCourse(courseRepository.findAllById(id));
    }

    public List<CourseDto> getWithPhrase(String phrase) {
        List<Course> courses =  courseRepository.findAll();
        List<Course> listWithPhrases = new ArrayList<>();
        for(Course course: courses) {
            if(course.getDisplayName().contains(phrase)) {
                listWithPhrases.add(course);
            }
        }
        return courseMapper.mapToListDtoCourse(listWithPhrases);
    }

    public List<CourseDto> getAllCourses() {
        return courseMapper.mapToListDtoCourse(courseRepository.findAll());
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void createCourse(CourseDto courseDto) {
        courseRepository.save(courseMapper.mapToCourse(courseDto));
    }
}
