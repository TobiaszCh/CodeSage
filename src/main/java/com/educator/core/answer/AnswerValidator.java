package com.educator.core.answer;

import com.educator.core.answer.dto.AnswerDto;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.exception.CodeSageUserException;
import com.educator.core.question.dto.QuestionDto;
import org.springframework.stereotype.Component;

@Component
public class AnswerValidator {

    public void validateDistinctAnswers(QuestionDto questionDto) {
        //TODO Investigate error
        validateNullQuestionAndAnswersDto(questionDto);
        int beforeDistinct = questionDto.getAnswers().size();
        int afterDistinct = (int) questionDto.getAnswers().stream().map(result -> result.getDisplayName().trim()).distinct().count();
        if (beforeDistinct != afterDistinct) {
            throw CodeSageUserException.withUserMessage("Odpowiedzi nie mogą się powtarzać");
        }
    }

    public void validateAtLeastOneCorrectAnswer(QuestionDto questionDto) {
        validateNullQuestionAndAnswersDto(questionDto);
        int correctAnswer = (int) questionDto.getAnswers().stream().filter(AnswerDto::isCorrect).count();
        if (correctAnswer < 1) {
            throw CodeSageUserException.withUserMessage("Musisz wybrać która odpowiedź jest właściwa");
        }
    }

    private void validateNullQuestionAndAnswersDto(QuestionDto questionDto) {
        if (questionDto == null || questionDto.getAnswers() == null) {
            throw new CodeSageRuntimeException("Object QuestionDto or AnswerDto List is null");
        }
        if (questionDto.getAnswers().isEmpty()) {
            throw new CodeSageRuntimeException("AnswerDto list is empty");
        }
        for (AnswerDto answerDto : questionDto.getAnswers()) {
            if (answerDto == null) throw new CodeSageRuntimeException("AnswerDto is null");
        }
    }

}
