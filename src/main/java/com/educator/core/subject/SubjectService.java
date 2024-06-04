package com.educator.core.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private Long courseId;
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;
  
    public List<SubjectDto> getAllSubjects() {
        return subjectMapper.mapToDtoSubjectList(subjectRepository.findAll());
    }

    public void createSubject(SubjectDto subjectDto) {
        subjectRepository.save(subjectMapper.mapToSubject(subjectDto));
    }

    public void deleteCourse(Long id) {
        subjectRepository.deleteById(id);
    }

    public void deleteAllCourse() {
        subjectRepository.deleteAll();
    }

    public void sendCourseIdFromAngular(Long courseId) {
        this.courseId = courseId;
    }

    public List<SubjectDto> getSubjectsFilterByCourseIdFromAngular() {
        return subjectMapper.mapToDtoSubjectList(subjectRepository.findAll()).stream()
                .filter(i -> i.getCourseId().equals(this.courseId)).collect(Collectors.toList());
    }
}
