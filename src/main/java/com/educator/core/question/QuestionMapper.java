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
        return QuestionDto.builder().id(question.getId())
                .displayName(question.getDisplayName())
                .subjectId(question.getSubject() != null ? question.getSubject().getId(): null)
                .answers(answerMapper.mapToListDtoAnswer(question.getAnswers()))
                .build();
    }

    public  Question mapToQuestion (QuestionDto questionDto) {
        return Question.builder()
                .id(questionDto.getId())
                .displayName(questionDto.getDisplayName())
                .subject(subjectRepository.getById(questionDto.getId()))
                .build();
    }

    public List<QuestionDto> mapToListDtoQuestion (List<Question> questions) {
        return questions.stream().map(this::mapToDtoQuestion).collect(Collectors.toList());
    }
}
