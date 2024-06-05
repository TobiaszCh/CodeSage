package com.educator.controller;
import com.educator.core.question.QuestionDto;
import com.educator.core.question.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
    public void createQuestion(@RequestBody QuestionDto questionDto) {
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

    @PostMapping("/subjectId")
    public void sendSubjectIdFromAngular(@RequestBody QuestionDto questionDto) {
        questionService.sendSubjectIdFromAngular(questionDto.getSubjectId());
    }

    @GetMapping("/subjectId/{nextQuestion}")
    public QuestionDto getQuestionFilterBySubjectIdFromAngular(@PathVariable String nextQuestion) {
        return questionService.getQuestionFilterBySubjectIdFromAngular(nextQuestion);
    }
}
