package com.educator.controller;

import com.educator.core.subject.SubjectService;
import com.educator.core.subject.dto.SubjectCompletionStatusDto;
import com.educator.core.subject.dto.SubjectDetailsDto;
import com.educator.core.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
@CrossOrigin(origins = {"http://localhost:4200", "https://code-sage-front-a970cdb2bc71.herokuapp.com", "https://www.codesage.pl"}, allowCredentials = "true")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public Long createSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    @DeleteMapping("/{id}")
    public void deleteSubjectById(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
    }

    @DeleteMapping
    public void deleteAllSubjects() {
        subjectService.deleteAllSubjects();
    }

    @GetMapping("/by-course/{courseId}")
    public List<SubjectDto> getSubjectsFilterByCourseId(@PathVariable Long courseId) {
        return subjectService.getSubjectsFilterByCourseId(courseId);
    }

    @GetMapping("/correct-answers-at-least-80/{courseId}")
    public List<SubjectCompletionStatusDto> getAllNumbersOfCorrectAnswersAtLeast80Percent(@PathVariable Long courseId) {
        return subjectService.getAllNumbersOfCorrectAnswersAtLeast80Percent(courseId);
    }

    @GetMapping("/{id}/course-id")
    public Long getCourseId(@PathVariable Long id) {
        return subjectService.getCourseId(id);
    }

    @GetMapping("/{id}")
    public SubjectDto getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PatchMapping("/{id}")
    public Long updateSubjectDetails(@PathVariable Long id, @Valid @RequestBody SubjectDetailsDto subjectDetailsDto) {
        return subjectService.updateSubjectDetails(id, subjectDetailsDto);
    }

}
