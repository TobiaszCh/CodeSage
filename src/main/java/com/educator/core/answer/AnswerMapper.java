package com.educator.core.answer;

import com.educator.core.answer.dto.AnswerDto;
import com.educator.core.answer.dto.AnswerWithoutCorrectDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AnswerMapper {

    public AnswerWithoutCorrectDto mapToDtoAnswerWithoutCorrect(Answer answer) {
        return new AnswerWithoutCorrectDto(
                answer.getId(),
                answer.getDisplayName(),
                answer.getQuestion() != null ? answer.getQuestion().getId() : null);
    }

    public AnswerDto mapToDtoAnswer(Answer answer) {
        return new AnswerDto(
                answer.getId(),
                answer.getDisplayName(),
                answer.isCorrect(),
                answer.getQuestion() != null ? answer.getQuestion().getId() : null);
    }

    public Answer mapToAnswer(AnswerDto answerDto) {
        return Answer.builder()
                .id(answerDto.getId())
                .displayName(answerDto.getDisplayName())
                .isCorrect(answerDto.isCorrect())
                .build();
    }

    public List<AnswerDto> mapToListDtoAnswer(List<Answer> answers) {
        return answers.stream().map(this::mapToDtoAnswer).collect(Collectors.toList());
    }

    public List<AnswerWithoutCorrectDto> mapToListDtoAnswerWithoutCorrect(List<Answer> answers) {
        return answers.stream().map(this::mapToDtoAnswerWithoutCorrect).collect(Collectors.toList());
    }

    public List<Answer> mapToListAnswer(List<AnswerDto> answers) {
        return answers.stream().map(this::mapToAnswer).collect(Collectors.toList());
    }

}
