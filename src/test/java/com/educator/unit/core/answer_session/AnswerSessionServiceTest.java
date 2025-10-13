package com.educator.unit.core.answer_session;

import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionMapper;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.AnswerSessionService;
import com.educator.core.answer_session.dto.AllPointsAnswerSessionDto;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.dto.SubjectIdToAnswerSessionDto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.course.Course;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import com.educator.core.user.Role;
import com.educator.core.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AnswerSessionServiceTest {

    @Mock
    private AnswerSessionRepository answerSessionRepository;

    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private AnswerSessionMapper answerSessionMapper;

    @Mock
    public AuthService authService;

    @InjectMocks
    public AnswerSessionService answerSessionService;


    @Test
    void sendSubjectIdToNewAnswerSession() {
        //Given
        Long subjectId = 1L;
        SubjectIdToAnswerSessionDto subjectIdToAnswerSessionDto = new SubjectIdToAnswerSessionDto(subjectId);
        User user = new User(2L, "Tobek","sdfsf", true, Role.USER, "Nothing", 0);
        Course course = Course.builder().id(3L).users(AuthService.getLoggedAdmin()).displayName("Course1").build();
        Subject subject = new Subject(4L, "Subject1", course);
        StatusAnswerSession statusAnswerSession = StatusAnswerSession.IN_PROGRESS;
        AnswerSession answerSession = AnswerSession.builder().id(5L).users(user).subject(subject)
                .statusAnswerSession(statusAnswerSession).sessionStartDate(LocalDate.now()).build();
        AnswerSessionDto answerSessionDto = new AnswerSessionDto(5L, 0,0,
                LocalDate.now(), statusAnswerSession, user.getId(), subject.getId());

        when(subjectRepository.getById(subjectId)).thenReturn(subject);
        when(authService.getLoggedUser()).thenReturn(user);
        when(answerSessionMapper.mapToAnswerSession(subject, user, statusAnswerSession)).thenReturn(answerSession);
        when(answerSessionRepository.save(answerSession)).thenReturn(answerSession);
        when(answerSessionMapper.mapToDtoAnswerSession(answerSession)).thenReturn(answerSessionDto);
        //When
        Long result = answerSessionService.sendSubjectIdToNewAnswerSession(subjectIdToAnswerSessionDto);
        //Then
        assertEquals(5L, result);
        assertNotEquals(4L, result);
        assertNotEquals(3L, result);
    }

    @Test
    void getPoints() {
        //Given
        Long id = 1L;
        User user = new User(2L, "Tobek","sdfsf", true, Role.USER, "Nothing", 0);
        Course course = Course.builder().id(3L).users(AuthService.getLoggedAdmin()).displayName("Course1").build();
        Subject subject = new Subject(4L, "Subject1", course);
        StatusAnswerSession statusAnswerSession = StatusAnswerSession.IN_PROGRESS;
        AnswerSession answerSession = AnswerSession.builder().id(id).users(user).subject(subject).allAnswers(10)
                .correctAnswers(8).statusAnswerSession(statusAnswerSession).sessionStartDate(LocalDate.now()).build();

        when(answerSessionRepository.findById(id)).thenReturn(Optional.ofNullable(answerSession));
        //When
        AllPointsAnswerSessionDto allPointsAnswerSessionDto1 = answerSessionService.getPoints(1L);
        //Then
        assertEquals(10, allPointsAnswerSessionDto1.getAllAnswers());
        assertEquals(8, allPointsAnswerSessionDto1.getCorrectAnswers());
        assertThrows(CodeSageRuntimeException.class, () -> answerSessionService.getPoints(null));
    }

}