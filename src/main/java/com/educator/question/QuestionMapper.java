package com.educator.question;

import com.educator.answer.AnswerMapper;
import com.educator.level.LevelMapper;
import com.educator.level.LevelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;
    private final LevelRepository levelRepository;

    public  QuestionDto mapToDtoQuestion(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getDisplayName(),
                question.getLevel() != null ? question.getLevel().getId(): null,
                answerMapper.mapToListDtoAnswer(question.getAnswers())
        );
    }

    public  Question mapToQuestion (QuestionDto questionDto) {
        return new Question(
                questionDto.getId(),
                questionDto.getDisplayName(),
                levelRepository.getById(questionDto.getId())
        );
    }

    public List<QuestionDto> mapToListDtoQuestion (List<Question> questions) {
        return questions.stream().map(this::mapToDtoQuestion).collect(Collectors.toList());
    }
}
