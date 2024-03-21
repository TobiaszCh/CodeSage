package com.educator.subject;

import com.educator.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;
@Component
@RequiredArgsConstructor
public class SubjectMapper {

    private final CourseRepository courseRepository;

    public SubjectDto mapToDtoSubject(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getDisplayName(),
                (subject.getCourse() != null) ? subject.getCourse().getId(): null);
    }

    public Subject mapToSubject(SubjectDto subjectDto) {
        return new Subject(
                subjectDto.getId(),
                subjectDto.getDisplayName(),
                courseRepository.getById(subjectDto.getCourseId()));
    }

    public List<SubjectDto> mapToDtoSubjectList(List<Subject> subjectList) {
        return subjectList.stream().map(this::mapToDtoSubject).collect(Collectors.toList());
    }
}
