package com.educator.controller;

import com.educator.core.question.dto.QuestionDto;
import com.educator.core.question.QuestionService;
import com.educator.core.question.dto.QuestionWithoutAnswerCorrectDto;
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

    @PostMapping
    public Long createQuestions(@Valid @RequestBody List<QuestionDto> questionDto) {
        return questionService.createQuestions(questionDto);
    }

    @GetMapping("/{subjectId}")
    public List<QuestionDto> getQuestionsBySubjectId(@PathVariable Long subjectId) {
        return questionService.getQuestionsBySubjectId(subjectId);
    }

    @GetMapping("/answerSessionId/{answerSessionId}")
    public QuestionWithoutAnswerCorrectDto getQuestionFilterBySubjectId(@PathVariable Long answerSessionId) {
        return questionService.getQuestionFilterBySubject(answerSessionId);
    }

    @GetMapping("/subjectId/{subjectId}")
    public boolean hasQuestionsInSubject(@PathVariable Long subjectId) {
        return questionService.hasQuestionsInSubject(subjectId);
    }

    @PatchMapping
    public Long updateQuestions(@Valid @RequestBody List<QuestionDto> questionDto) {
        return questionService.updateQuestions(questionDto);
    }

}
