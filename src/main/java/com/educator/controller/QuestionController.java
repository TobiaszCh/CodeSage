package com.educator.controller;

import com.educator.aspect.AccessPolicy;
import com.educator.aspect.CourseAccess;
import com.educator.aspect.EntityType;
import com.educator.core.question.QuestionService;
import com.educator.core.question.dto.QuestionDto;
import com.educator.core.question.dto.QuestionResponseDto;
import com.educator.core.question.dto.QuestionsDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/questions")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://code-sage-front-a970cdb2bc71.herokuapp.com",
        "https://www.codesage.pl"
}, allowCredentials = "true")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#questionsDto.questions[0].subjectId",
            accessPolicy = AccessPolicy.MANAGE
    )
    public Long createQuestions(@Valid @RequestBody QuestionsDto questionsDto) {
        return questionService.createQuestions(questionsDto.getQuestions());
    }

    @GetMapping("/{subjectId}")
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#subjectId",
            accessPolicy = AccessPolicy.LEARN
    )
    public List<QuestionDto> getQuestionsBySubjectId(@PathVariable Long subjectId) {
        return questionService.getQuestionsBySubjectId(subjectId);
    }

    @GetMapping("/answerSessionId/{answerSessionId}")
    @CourseAccess(
            idEntityType = EntityType.ANSWER_SESSION,
            idExpression = "#answerSessionId",
            accessPolicy = AccessPolicy.LEARN
    )
    public QuestionResponseDto getQuestionByAnswerSessionId(@PathVariable Long answerSessionId) {
        return questionService.getQuestionByAnswerSessionId(answerSessionId);
    }

    @GetMapping("/subjectId/{subjectId}")
    @CourseAccess(
            idEntityType = EntityType.SUBJECT,
            idExpression = "#subjectId",
            accessPolicy = AccessPolicy.LEARN
    )
    public boolean hasQuestionsInSubject(@PathVariable Long subjectId) {
        return questionService.hasQuestionsInSubject(subjectId);
    }

}
