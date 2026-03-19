package com.educator.core.question;

import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.dto.QuestionDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class QuestionValidator {

    public void validateDistinctQuestions(List<QuestionDto> questionDto) {
        if (questionDto == null) throw new CodeSageRuntimeException("Object is null");
        if (questionDto.isEmpty()) throw new CodeSageRuntimeException("List is empty");
        List<String> uniqueTheSameNames = questionDto.stream().map(QuestionDto::getDisplayName).distinct().collect(Collectors.toList());
        if (uniqueTheSameNames.size() != questionDto.size()) {
            throw new CodeSageRuntimeException("Pytania nie mogą się powtarzać");
        }
    }

    public void validateAllSubjectIdEquals(List<QuestionDto> questionDto) {
        if (questionDto == null) throw new CodeSageRuntimeException("Object is null");
        if (questionDto.isEmpty()) throw new CodeSageRuntimeException("List is empty");
        int quantityOfSubjects = (int) questionDto.stream().map(QuestionDto::getSubjectId).distinct().count();
        if (quantityOfSubjects > 1) {
            throw new CodeSageRuntimeException("All subjectId aren't equals");
        }
    }

}
