package com.educator.subject;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class SubjectMapper {

    public SubjectDto mapToDtoSubject(Subject subject) {
        return new SubjectDto(
                subject.getId(),
                subject.getDisplayName());
    }

    public Subject mapToSubject(SubjectDto subjectDto) {
        return new Subject(
                subjectDto.getId(),
                subjectDto.getDisplayName());
    }

    public List<SubjectDto> mapToDtoSubjectList(List<Subject> subjectList) {
        return subjectList.stream().map(this::mapToDtoSubject).collect(Collectors.toList());
    }
}
