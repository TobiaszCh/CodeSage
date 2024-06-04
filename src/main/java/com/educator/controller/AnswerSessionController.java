package com.educator.controller;
import com.educator.core.answer_session.AnswerSessionDto;
import com.educator.core.answer_session.AnswerSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/answer-session")
public class AnswerSessionController {

    private final AnswerSessionService answerSessionService;

    @GetMapping
    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionService.getAllAnswer();
    }

    @PostMapping("/subjectId")
    public Long sendSubjectIdToAnswerSession(@RequestBody AnswerSessionDto answerSessionDto) {
        return answerSessionService.sendSubjectIdToAnswerSession(answerSessionDto);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        answerSessionService.deleteById(id);
    }

    //Metoda Post selectQuestionAnswer(answerSessionId, questionId, answerId)
    //ta metoda sprawdza czy odp jest prawidłowa, podbija licznik wszystkich odpowiedzi i prawidłowych odpowiedzi)
    //zwraca correctAnswerId
}
