package com.educator.controller;
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
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AnswerSessionController {

    private final AnswerSessionService answerSessionService;

    @GetMapping
    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionService.getAllAnswer();
    }

    @PostMapping("/subjectId")
    public Long sendSubjectIdToAnswerSession(@Valid @RequestBody SubjectIdToAnswerSessionDto subjectIdToAnswerSessionDto) {
        return answerSessionService.sendSubjectIdToNewAnswerSession(subjectIdToAnswerSessionDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        answerSessionService.deleteById(id);
    }

    @PutMapping(value = "/selectQuestionAnswer/{id}")
    public Long selectQuestionAnswer(@PathVariable Long id,@Valid @RequestBody QuestionAnswerSelectDto questionAnswerSelectDto) {
        return answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDto);
    }

    @PutMapping(value = "/updateStatus/{id}")
    public void updateAnswerSessionStatus(@PathVariable Long id) {
        answerSessionService.updateAnswerSessionStatus(id);
    }
}
