package com.educator.core.answer_session;
import com.educator.core.user.User;
import com.educator.core.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AnswerSessionMapper {

    private final SubjectRepository subjectRepository;

    public AnswerSessionDto mapToDtoAnswerSession(AnswerSession answerSession) {
        return new AnswerSessionDto(
                answerSession.getId(),
                answerSession.getUserPoints(),
                answerSession.getUsers() != null ? answerSession.getUsers().getId(): null,
                answerSession.getSubject() != null ? answerSession.getSubject().getId(): null);
    }

    public AnswerSession mapToAnswerSession(AnswerSessionDto answerSessionDto) {
        return new AnswerSession(
                answerSessionDto.getId(),
                new User(69L, "TestUser", "beginner", 0),
                subjectRepository.getById(answerSessionDto.getSubjectId()));
    }

    public List<AnswerSessionDto> mapToListDtoAnswerSession(List<AnswerSession> answerSession) {
        return answerSession.stream().map(this::mapToDtoAnswerSession).collect(Collectors.toList());
    }
}
