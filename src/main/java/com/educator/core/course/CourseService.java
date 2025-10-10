package com.educator.core.course;
import com.educator.core.exception.CodeSageRuntimeException;
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
        return courseMapper.mapToDtoCourse(courseRepository.findById(id)
                .orElseThrow(() -> new CodeSageRuntimeException("This course doesn't exist")));
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

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public void createCourse(CourseDto courseDto) {
        courseRepository.save(courseMapper.mapToCourse(courseDto));
    }

    public void updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CodeSageRuntimeException("Id is null"));
        course.setDisplayName(courseDto.getDisplayName());
        courseRepository.save(course);
    }
}
