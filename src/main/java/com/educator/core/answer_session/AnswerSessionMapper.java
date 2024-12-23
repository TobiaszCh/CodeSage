package com.educator.core.answer_session;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.dto.SubjectIdToAnswerSessionDto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import com.educator.core.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AnswerSessionMapper {

    public AnswerSessionDto mapToDtoAnswerSession(AnswerSession answerSession) {
        return new AnswerSessionDto(
                answerSession.getId(),
                answerSession.getAllAnswers(),
                answerSession.getCorrectAnswers(),
                answerSession.getSessionStartDate(),
                answerSession.getStatusAnswerSession(),
                answerSession.getUsers() != null ? answerSession.getUsers().getId(): null,
                answerSession.getSubject() != null ? answerSession.getSubject().getId(): null);
    }

    public AnswerSession mapToAnswerSession(Subject subject, User user, StatusAnswerSession statusAnswerSession) {
        return AnswerSession.builder()
                .users(user)
                .subject(subject)
                .statusAnswerSession(statusAnswerSession)
                .sessionStartDate(LocalDate.now())
                .build();

    }

    public List<AnswerSessionDto> mapToListDtoAnswerSession(List<AnswerSession> answerSession) {
        return answerSession.stream().map(this::mapToDtoAnswerSession).collect(Collectors.toList());
    }
}
