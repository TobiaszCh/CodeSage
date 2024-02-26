package com.educator.question;

import com.educator.answer.Answer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class QuestionMapper {

    public  QuestionDto mapToDtoQuestion(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getDisplayName(),
                question.getAnswers().stream().map(Answer::getDisplayName).collect(Collectors.toList())
        );
    }

    public  Question mapToQuestion (QuestionDto questionDto) {
        return new Question(
                questionDto.getId(),
                questionDto.getDisplayName()
        );
    }

    public List<QuestionDto> mapToListDtoQuestion (List<Question> questions) {
        return questions.stream().map(this::mapToDtoQuestion).collect(Collectors.toList());
    }
}
