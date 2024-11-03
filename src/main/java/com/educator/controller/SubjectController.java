package com.educator.controller;
import com.educator.core.subject.SubjectDto;
import com.educator.core.subject.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public void createSubject(@Valid @RequestBody SubjectDto subjectDto) {
        subjectService.createSubject(subjectDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteCourse(id);
    }

    @DeleteMapping
    public void deleteAllSubject() {
        subjectService.deleteAllCourse();
    }

    @GetMapping(value = "/{courseId}")
    public List<SubjectDto> getSubjectsFilterByCourseIdFromAngular(@PathVariable Long courseId) {
        return subjectService.getSubjectsFilterByCourseIdFromAngular(courseId);
    }
}
