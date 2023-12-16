package com.educator.subject;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    @GetMapping
    public List<SubjectDto> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
    @PostMapping
    public void createSubject(@RequestBody SubjectDto subjectDto) {
        subjectService.createSubject(subjectDto);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCourse(@PathVariable Long id) {
        subjectService.deleteCourse(id);
    }
    @DeleteMapping
    public void deleteAllCourse() {
        subjectService.deleteAllCourse();
    }

}
