package com.educator.question;

import com.educator.answer.Answer;
import com.educator.answer.AnswerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;

    public  QuestionDto mapToDtoQuestion(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getDisplayName(),
                answerMapper.mapToListDtoAnswer(question.getAnswers())
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
