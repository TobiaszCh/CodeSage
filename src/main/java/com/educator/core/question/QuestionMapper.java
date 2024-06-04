package com.educator.core.question;

import com.educator.core.answer.AnswerMapper;
import com.educator.core.subject.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
@AllArgsConstructor
public class QuestionMapper {

    private final AnswerMapper answerMapper;
    private final SubjectRepository subjectRepository;

    public  QuestionDto mapToDtoQuestion(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getDisplayName(),
                question.getSubject() != null ? question.getSubject().getId(): null,
                answerMapper.mapToListDtoAnswer(question.getAnswers())
        );
    }

    public  Question mapToQuestion (QuestionDto questionDto) {
        return new Question(
                questionDto.getId(),
                questionDto.getDisplayName(),
                subjectRepository.getById(questionDto.getId())
        );
    }

    public List<QuestionDto> mapToListDtoQuestion (List<Question> questions) {
        return questions.stream().map(this::mapToDtoQuestion).collect(Collectors.toList());
    }
}
