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
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<QuestionDto> getAllQuestions () {
        return questionService.getAllQuestions();
    }

    @PostMapping
    public void createQuestion(@Valid @RequestBody QuestionDto questionDto) {
        questionService.createQuestion(questionDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping(value = "/{id}")
    public QuestionDto getQuestionById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/answerSessionId/{answerSessionId}")
    public QuestionDto getQuestionFilterBySubjectIdFromAngular(@PathVariable Long answerSessionId) {
        return questionService.getQuestionFilterBySubject(answerSessionId);
    }
}
