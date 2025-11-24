package com.educator.core.answer;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.QuestionDto;
import org.springframework.stereotype.Component;

@Component
public class AnswerValidator {
    public void validateDistinctAnswers(QuestionDto questionDto) {
        if(questionDto == null) throw new CodeSageRuntimeException("Object is null");
        int beforeDistinct = questionDto.getAnswers().size();
        int afterDistinct = (int) questionDto.getAnswers().stream().map(AnswerDto::getDisplayName).distinct().count();
        if(beforeDistinct != afterDistinct) {
            throw new CodeSageRuntimeException("Odpowiedzi nie mogą się powtarzać");
        }
    }

    public void validateAtLeastOneCorrectAnswer(QuestionDto questionDto) {
        if(questionDto == null) throw new CodeSageRuntimeException("Object is null");
        int correctAnswer = (int) questionDto.getAnswers().stream().filter(AnswerDto::isCorrect).count();
        if(correctAnswer < 1) {
            throw new CodeSageRuntimeException("Musisz wybrać która odpowiedź jest właściwa");
        }
    }

}
