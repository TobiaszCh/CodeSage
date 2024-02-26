package com.educator.question;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/questions")
@AllArgsConstructor
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
}
