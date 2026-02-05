package com.educator.core.course;

import com.educator.auth.AuthService;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    private final AuthService authService;

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

    public List<CourseDto> getAllMyCourses() {
        User loggedUser = authService.getLoggedUser();
        return courseMapper.mapToListDtoCourse(courseRepository.findAllByUsersContains(loggedUser));
    }

    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    public void createMyCourse(CourseDto courseDto) {
        User loggedUser = authService.getLoggedUser();
        courseRepository.save(courseMapper.mapToCourse(courseDto, List.of(loggedUser)));
    }

    public void updateCourse(Long id, CourseDto courseDto) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new CodeSageRuntimeException("This course doesn't exist"));
        course.setDisplayName(courseDto.getDisplayName());
        courseRepository.save(course);
    }

}
