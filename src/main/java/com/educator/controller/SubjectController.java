package com.educator.controller;
import com.educator.core.subject.SubjectDto;
import com.educator.core.subject.SubjectService;
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
    @DeleteMapping(value = "/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteCourse(id);
    }
    @DeleteMapping
    public void deleteAllSubject() {
        subjectService.deleteAllCourse();
    }

    @PostMapping("/courseId")
    public void sendCourseIdFromAngular(@RequestBody SubjectDto subjectDto) {
        subjectService.sendCourseIdFromAngular(subjectDto.getCourseId());
    }
    @GetMapping("/courseId")
    public List<SubjectDto> getSubjectsFilterByCourseIdFromAngular() {
        return subjectService.getSubjectsFilterByCourseIdFromAngular();
    }

}
