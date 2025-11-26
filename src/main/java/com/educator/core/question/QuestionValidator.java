package com.educator.core.question;

import com.educator.core.exception.CodeSageRuntimeException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class QuestionValidator {

    private final QuestionRepository questionRepository;
    public void validateDistinctQuestions(QuestionDto questionDto) {
        if(questionDto == null) throw new CodeSageRuntimeException("Object is null");
        if(questionRepository.existsBySubjectIdAndDisplayName(questionDto.getSubjectId(), questionDto.getDisplayName())) {
            throw new CodeSageRuntimeException("Pytania nie mogą się powtarzać");
        }
    }

}
