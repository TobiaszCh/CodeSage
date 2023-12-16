package com.educator.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

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
}
