package com.educator.dev.init;
import com.educator.auth.AuthService;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.List;

@Component
@AllArgsConstructor
@ConditionalOnProperty(prefix = "dev", name = "data.init", havingValue = "true")
public class CourseDataInitializer {

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initializeCourseData () {
        courseRepository.save(Course.builder().id(-1L).users(List.of(AuthService.getLoggedAdmin())).displayName("Java").build());
        courseRepository.save(Course.builder().id(-2L).users(List.of(AuthService.getLoggedAdmin())).displayName("TypeScript").build());
        courseRepository.save(Course.builder().id(-3L).users(List.of(AuthService.getLoggedAdmin())).displayName("Python").build());
        courseRepository.save(Course.builder().id(-4L).users(List.of(AuthService.getLoggedAdmin())).displayName("JavaScript").build());
        courseRepository.save(Course.builder().id(-5L).users(List.of(AuthService.getLoggedAdmin())).displayName("React").build());
        courseRepository.save(Course.builder().id(-6L).users(List.of(AuthService.getLoggedAdmin())).displayName("Kotlin").build());
        courseRepository.save(Course.builder().id(-7L).users(List.of(AuthService.getLoggedAdmin())).displayName("C++").build());
        courseRepository.save(Course.builder().id(-8L).users(List.of(AuthService.getLoggedAdmin())).displayName("PHP").build());
        courseRepository.save(Course.builder().id(-183L).users(List.of(AuthService.getLoggedAdmin())).displayName("Ruby").build());
    }
}
