package com.educator.controller;
import com.educator.core.answer_session.dto.AllPointsAnswerSessionDto;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import com.educator.core.answer_session.dto.SubjectIdToAnswerSessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/answer-session")
@CrossOrigin(origins = {"http://localhost:4200", "https://code-sage-front-a970cdb2bc71.herokuapp.com"}, allowCredentials = "true")
public class AnswerSessionController {

    private final AnswerSessionService answerSessionService;

    @GetMapping
    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionService.getAllAnswer();
    }

    @GetMapping("/{id}")
    public AllPointsAnswerSessionDto getPoints(@PathVariable Long id) {
        return answerSessionService.getPoints(id);
    }

    @PostMapping("/subjectId")
    public Long sendSubjectIdToAnswerSession(@Valid @RequestBody SubjectIdToAnswerSessionDto subjectIdToAnswerSessionDto) {
        return answerSessionService.sendSubjectIdToNewAnswerSession(subjectIdToAnswerSessionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        answerSessionService.deleteById(id);
    }

    @PutMapping("/selectQuestionAnswer/{id}")
    public Long selectQuestionAnswer(@PathVariable Long id,@Valid @RequestBody QuestionAnswerSelectDto questionAnswerSelectDto) {
        return answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDto);
    }

    @PutMapping("/updateStatus/{id}")
    public void updateAnswerSessionStatus(@PathVariable Long id) {
        answerSessionService.updateAnswerSessionStatus(id);
    }

    @GetMapping("/{id}/course-id")
    public Long getCourseId(@PathVariable Long id) {
        return answerSessionService.getCourseId(id);
    }

}
