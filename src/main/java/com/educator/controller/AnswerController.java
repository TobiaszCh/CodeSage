package com.educator.controller;
import com.educator.core.answer.dto.AnswerDto;
import com.educator.core.answer.dto.AnswerWithoutCorrectDto;
import com.educator.core.answer.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping
    public List<AnswerWithoutCorrectDto> getAllAnswer () {
        return answerService.getAllAnswer();
    }

    @DeleteMapping("/{id}")
    public void deleteAnswer(@PathVariable Long id) {
        answerService.deleteAnswer(id);
    }

    @PostMapping
    public void createAnswer(@Valid @RequestBody AnswerDto answerDto) {
        answerService.createAnswer(answerDto);
    }

}
