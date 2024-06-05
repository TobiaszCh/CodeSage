package com.educator.dev.init;
import com.educator.core.course.CourseRepository;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
@AllArgsConstructor
@Profile("development")
@DependsOn("courseDataInitializer")
public class SubjectDataInitializer {

    private final SubjectRepository subjectRepository;

    private final CourseRepository courseRepository;

    @PostConstruct
    public void initializeSubjectData () {
        subjectRepository.save(new Subject(9L, "Klasy", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(10L, "Klasy abstrakcyjne", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(11L, "Interfejsy", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(12L, "Enumy", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(13L, "Atrybuty/Pola", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(14L, "Metody", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(15L, "Adnotacje", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(16L, "Kolekcje", courseRepository.getById(1L)));
        subjectRepository.save(new Subject(17L, "Funkcje", courseRepository.getById(1L)));

    }
}
