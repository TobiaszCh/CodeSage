package com.educator.core.answer;
import com.educator.core.question.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class AnswerMapper {

    private final QuestionRepository questionRepository;

    public AnswerDto mapToDtoAnswer(Answer answer) {
        return new AnswerDto(answer.getId(),
                answer.getDisplayName(),
                answer.isCorrect(),
                answer.getQuestion() != null ? answer.getQuestion().getId(): null);
    }

    public Answer mapToAnswer (AnswerDto answerDto) {
        return new Answer(answerDto.getId(),
                answerDto.getDisplayName(),
                answerDto.isCorrect(),
                questionRepository.getById(answerDto.getQuestionId()));
    }

    public List<AnswerDto> mapToListDtoAnswer(List<Answer> answers) {
        return answers.stream().map(this::mapToDtoAnswer).collect(Collectors.toList());
    }


}
