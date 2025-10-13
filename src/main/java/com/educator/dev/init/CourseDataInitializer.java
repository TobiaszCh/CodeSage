package com.educator.dev.init;
import com.educator.auth.AuthService;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import com.educator.core.course.enums.StatusCourse;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@ConditionalOnProperty(prefix = "dev", name = "data.init", havingValue = "true")
public class CourseDataInitializer {

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initializeCourseData () {
        courseRepository.save(Course.builder().id(-1L).users(AuthService.getLoggedAdmin()).displayName("Java").build());
        courseRepository.save(Course.builder().id(-2L).users(AuthService.getLoggedAdmin()).displayName("TypeScript").build());
        courseRepository.save(Course.builder().id(-3L).users(AuthService.getLoggedAdmin()).displayName("Python").build());
        courseRepository.save(Course.builder().id(-4L).users(AuthService.getLoggedAdmin()).displayName("JavaScript").build());
        courseRepository.save(Course.builder().id(-5L).users(AuthService.getLoggedAdmin()).displayName("React").build());
        courseRepository.save(Course.builder().id(-6L).users(AuthService.getLoggedAdmin()).displayName("Kotlin").build());
        courseRepository.save(Course.builder().id(-7L).users(AuthService.getLoggedAdmin()).displayName("C++").build());
        courseRepository.save(Course.builder().id(-8L).users(AuthService.getLoggedAdmin()).displayName("PHP").build());
        courseRepository.save(Course.builder().id(-183L).users(AuthService.getLoggedAdmin()).displayName("Ruby").build());
    }
}
