package com.educator.controller;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.answer_session.dto.AnswerSessionStatusIdDto;
import com.educator.core.answer_session.dto.CheckCompletedSessionsDto;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/answer-session")
@CrossOrigin(origins = "http://localhost:4200")
public class AnswerSessionController {

    private final AnswerSessionService answerSessionService;

    @GetMapping
    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionService.getAllAnswer();
    }

    @PostMapping("/subjectId")
    public Long sendSubjectIdToAnswerSession(@Valid @RequestBody AnswerSessionDto answerSessionDto) {
        return answerSessionService.sendSubjectIdToAnswerSession(answerSessionDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        answerSessionService.deleteById(id);
    }
    //Metoda Post selectQuestionAnswer(answerSessionId, questionId, answerId)
    //ta metoda sprawdza czy odp jest prawidłowa, podbija licznik wszystkich odpowiedzi i prawidłowych odpowiedzi)
    //zwraca correctAnswerId
    @PutMapping(value = "/selectQuestionAnswer/{id}")
    public Long selectQuestionAnswer(@PathVariable Long id, @RequestBody QuestionAnswerSelectDto questionAnswerSelectDto) {
        return answerSessionService.selectQuestionAnswer(id, questionAnswerSelectDto);
    }
    @PutMapping(value = "/updateStatus/{id}")
    public void updateAnswerSessionStatus(@PathVariable Long id, @RequestBody AnswerSessionStatusIdDto answerSessionStatusIdDto) {
        answerSessionService.updateAnswerSessionStatus(id, answerSessionStatusIdDto);
    }
    @GetMapping(value = "/correctAnswersAtLeast80Percent/{courseId}")
    public List<CheckCompletedSessionsDto> getAllNumbersOfCorrectAnswersAtLeast80Percent(@PathVariable Long courseId) {
        return answerSessionService.getAllNumbersOfCorrectAnswersAtLeast80Percent(courseId);
    }

}
