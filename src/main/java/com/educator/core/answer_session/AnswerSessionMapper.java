package com.educator.core.answer_session;
import com.educator.auth.AuthService;
import com.educator.core.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AnswerSessionMapper {

    private final AuthService authService;

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
                authService.getLoggedUser(),
                subjectRepository.getById(answerSessionDto.getSubjectId()));
    }

    public List<AnswerSessionDto> mapToListDtoAnswerSession(List<AnswerSession> answerSession) {
        return answerSession.stream().map(this::mapToDtoAnswerSession).collect(Collectors.toList());
    }
}
