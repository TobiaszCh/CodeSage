package com.educator.dev.init;
import com.educator.core.course.Course;
import com.educator.core.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Profile("development")
public class CourseDataInitializer {

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initializeCourseData () {
        courseRepository.save(new Course(-1L, "Java"));
        courseRepository.save(new Course(-2L, "TypeScript"));
        courseRepository.save(new Course(-3L, "Python"));
        courseRepository.save(new Course(-4L, "JavaScript"));
        courseRepository.save(new Course(-5L, "React"));
        courseRepository.save(new Course(-6L, "Kotlin"));
        courseRepository.save(new Course(-7L, "C++"));
        courseRepository.save(new Course(-8L, "PHP"));
        courseRepository.save(new Course(-183L, "Ruby"));
    }
}
