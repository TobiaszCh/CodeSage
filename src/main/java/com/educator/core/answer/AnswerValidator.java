package com.educator.core.answer;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.QuestionDto;
import org.springframework.stereotype.Component;

import java.util.List;

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

    public void validateAllSubjectIdEquals(List<QuestionDto> questionDto) {
        if(questionDto == null) throw new CodeSageRuntimeException("QuestionDto is null");
        if(questionDto.isEmpty()) throw new CodeSageRuntimeException("List is empty");;
        int quantityOfSubjects = (int) questionDto.stream().map(QuestionDto::getSubjectId).distinct().count();
        if (quantityOfSubjects > 1) {
            throw new CodeSageRuntimeException("All subjectId aren't equals");
        }
    }

}
