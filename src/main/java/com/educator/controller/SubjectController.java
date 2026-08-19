package com.educator.controller;

import com.educator.aspect.AccessPolicy;
import com.educator.aspect.CourseAccess;
import com.educator.aspect.EntityType;
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
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://code-sage-front-a970cdb2bc71.herokuapp.com",
        "https://www.codesage.pl"
}, allowCredentials = "true")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    @CourseAccess(
            idEntityType = EntityType.COURSE,
            idExpression = "#subjectDto.courseId",
            accessPolicy = AccessPolicy.MANAGE
    )
    public Long createSubject(@Valid @RequestBody SubjectDto subjectDto) {
        return subjectService.createSubject(subjectDto);
    }

    @DeleteMapping("/{id}")
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#id",
            accessPolicy = AccessPolicy.MANAGE
    )
    public void deleteSubjectById(@PathVariable Long id) {
        subjectService.deleteSubjectById(id);
    }

    @GetMapping("/by-course/{courseId}")
    @CourseAccess(
            idEntityType = EntityType.COURSE,
            idExpression = "#courseId",
            accessPolicy = AccessPolicy.LEARN
    )
    public List<SubjectDto> getSubjectsByCourseId(@PathVariable Long courseId) {
        return subjectService.getSubjectsByCourseId(courseId);
    }

    @GetMapping("/correct-answers-at-least-80/{courseId}")
    @CourseAccess(
            idEntityType = EntityType.COURSE,
            idExpression = "#courseId",
            accessPolicy = AccessPolicy.LEARN
    )
    public List<SubjectCompletionStatusDto> getAllNumbersOfCorrectAnswersAtLeast80Percent(@PathVariable Long courseId) {
        return subjectService.getAllNumbersOfCorrectAnswersAtLeast80Percent(courseId);
    }

    @GetMapping("/{id}/course-id")
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#id",
            accessPolicy = AccessPolicy.LEARN
    )
    public Long getCourseId(@PathVariable Long id) {
        return subjectService.getCourseId(id);
    }

    @GetMapping("/{id}")
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#id",
            accessPolicy = AccessPolicy.LEARN
    )
    public SubjectDto getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    @PatchMapping("/{id}")
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#id",
            accessPolicy = AccessPolicy.MANAGE
    )
    public Long updateSubjectDetails(@PathVariable Long id, @Valid @RequestBody SubjectDetailsDto subjectDetailsDto) {
        return subjectService.updateSubjectDetails(id, subjectDetailsDto);
    }

}
