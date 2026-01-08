package com.educator.controller;
import com.educator.core.question.QuestionDto;
import com.educator.core.question.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/questions")
@CrossOrigin(origins = {"http://localhost:4200", "https://code-sage-front-a970cdb2bc71.herokuapp.com"}, allowCredentials = "true")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDto> getAllQuestions () {
        return questionService.getAllQuestions();
    }

    @PostMapping
    public Long createQuestions(@Valid @RequestBody List<QuestionDto> questionDto) {
        return questionService.createQuestions(questionDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping("/{subjectId}")
    public List<QuestionDto> getQuestionsBySubjectId(@PathVariable Long subjectId) {
        return questionService.getQuestionsBySubjectId(subjectId);
    }

    @GetMapping("/answerSessionId/{answerSessionId}")
    public QuestionDto getQuestionFilterBySubjectId(@PathVariable Long answerSessionId) {
        return questionService.getQuestionFilterBySubject(answerSessionId);
    }

    @GetMapping("/subjectId/{subjectId}")
    public boolean hasQuestionsInSubject(@PathVariable Long subjectId) {
        return questionService.hasQuestionsInSubject(subjectId);
    }
}
