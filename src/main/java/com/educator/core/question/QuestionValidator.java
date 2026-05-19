package com.educator.core.question;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.exception.CodeSageUserException;
import com.educator.core.question.dto.QuestionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionValidator {

    public void validateDistinctQuestions(List<QuestionDto> questionsDto) {
        validateNullQuestionsDto(questionsDto);
        List<String> uniqueTheSameNames = questionsDto.stream().map(result -> result.getDisplayName().trim()).distinct().collect(Collectors.toList());
        if (uniqueTheSameNames.size() != questionsDto.size()) {
            throw CodeSageUserException.withUserMessage("Pytania nie mogą się powtarzać");
        }
    }

    public void validateAllSubjectIdEquals(List<QuestionDto> questionsDto) {
        validateNullQuestionsDto(questionsDto);
        int quantityOfSubjects = (int) questionsDto.stream().map(QuestionDto::getSubjectId).distinct().count();
        if (quantityOfSubjects > 1) {
            throw new CodeSageRuntimeException("All subjectId aren't equals");
        }
    }

    private void validateNullQuestionsDto(List<QuestionDto> questionsDto) {
        if (questionsDto == null) {
            throw new CodeSageRuntimeException("QuestionDto list is null");
        }
        if (questionsDto.isEmpty()) {
            throw new CodeSageRuntimeException("QuestionDto list is empty");
        }
        for(QuestionDto questionDto: questionsDto) {
            if (questionDto == null) throw new CodeSageRuntimeException("QuestionDto is null");
        }
    }

}
