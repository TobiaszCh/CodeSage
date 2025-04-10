package com.educator.unit.core.subject;

import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.course.Course;
import com.educator.core.subject.*;
import com.educator.core.subject.dto.CheckCompletedSessionsDto;
import com.educator.core.subject.dto.SubjectDto;
import com.educator.core.user.Role;
import com.educator.core.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class SubjectServiceTest {


    @Mock
    private SubjectRepository subjectRepository;

    @Mock
    private AnswerSessionRepository answerSessionRepository;

    @Mock
    private AuthService authService;

    @Mock
    private SubjectMapper subjectMapper;

    @InjectMocks
    private SubjectService subjectService;

    @Test
    void getSubjectsFilterByCourseId() {
        //Given
        List<Subject> subjects = new ArrayList<>();
        subjects.add(new Subject(10L, "Subject1", new Course(1L, "Course1")));
        subjects.add(new Subject(11L, "Subject2", new Course(1L, "Course1")));
        subjects.add(new Subject(12L, "Subject3", new Course(1L, "Course1")));
        subjects.add(new Subject(13L, "Subject4", new Course(2L, "Course2")));

        List<SubjectDto> subjectsDto = new ArrayList<>();
        subjectsDto.add(new SubjectDto(10L, "Subject1", 1L));
        subjectsDto.add(new SubjectDto(11L, "Subject2", 1L));
        subjectsDto.add(new SubjectDto(12L, "Subject3", 1L));
        subjectsDto.add(new SubjectDto(13L, "Subject4", 2L));

        when(subjectRepository.findAll()).thenReturn(subjects);
        when(subjectMapper.mapToDtoSubjectList(subjects)).thenReturn(subjectsDto);

        //When
        List<SubjectDto> result1 = subjectService.getSubjectsFilterByCourseId(1L);
        List<SubjectDto> result2 = subjectService.getSubjectsFilterByCourseId(2L);
        List<SubjectDto> result3 = subjectService.getSubjectsFilterByCourseId(3L);
        List<SubjectDto> result4 = subjectService.getSubjectsFilterByCourseId(null);

        //Then
        assertEquals(3, result1.size());
        assertEquals(1, result2.size());
        assertEquals(0, result3.size());
        assertEquals(0, result4.size());
        assertEquals("Subject3", result1.get(2).getDisplayName());

    }

    @Test
    void getAllNumbersOfCorrectAnswersAtLeast80Percent() {
        //Given
        Subject subject1 = new Subject(10L, "Subject1", new Course(1L, "Course1"));
        Subject subject2 = new Subject(11L, "Subject2", new Course(1L, "Course1"));
        Subject subject3 = new Subject(12L, "Subject3", new Course(1L, "Course1"));
        Subject subject4 = new Subject(13L, "Subject4", new Course(2L, "Course2"));

        List<Subject> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        subjects.add(subject3);

        User user = new User(4L, "Tobek","fsfsf", true, Role.USER, "Nothing", 0);

        AnswerSession answerSession1 = new AnswerSession(14L, 10, 7,
                LocalDate.now().minusDays(1), StatusAnswerSession.COMPLETED, user, subject1);
        AnswerSession answerSession2 = new AnswerSession(15L, 10, 0,
                LocalDate.now().minusDays(3), StatusAnswerSession.COMPLETED, user, subject2);
        AnswerSession answerSession3 = new AnswerSession(16L, 10, 10,
                LocalDate.now().minusDays(7), StatusAnswerSession.COMPLETED, user, subject3);
        AnswerSession answerSession4 = new AnswerSession(17L, 10, 8,
                LocalDate.now().minusDays(8), StatusAnswerSession.COMPLETED, user, subject3);
        AnswerSession answerSession5 = new AnswerSession(18L, 10, 8,
                LocalDate.now().minusDays(5), StatusAnswerSession.COMPLETED, user, subject4);

        List<AnswerSession> answerSessionsTests = new ArrayList<>();
        answerSessionsTests.add(answerSession1);
        answerSessionsTests.add(answerSession2);
        answerSessionsTests.add(answerSession3);
        answerSessionsTests.add(answerSession4);
        answerSessionsTests.add(answerSession5);

        when(subjectRepository.findByCourseId(1L)).thenReturn(subjects);
        when(answerSessionRepository.findByStatusAnswerSession(StatusAnswerSession.COMPLETED)).thenReturn(answerSessionsTests);
        when(authService.getLoggedUser()).thenReturn(user);

        //When
        List<CheckCompletedSessionsDto> resultTest1 = subjectService.getAllNumbersOfCorrectAnswersAtLeast80Percent(1L);
        List<CheckCompletedSessionsDto> resultTest2 = subjectService.getAllNumbersOfCorrectAnswersAtLeast80Percent(2L);
        List<CheckCompletedSessionsDto> resultTest3 = subjectService.getAllNumbersOfCorrectAnswersAtLeast80Percent(3L);
        List<CheckCompletedSessionsDto> resultTest4 = subjectService.getAllNumbersOfCorrectAnswersAtLeast80Percent(null);


        SubjectCompletedAge subjectCompletedAge3 = resultTest1.stream().filter(id -> id.getAnswerSessionId().equals(16L))
                .map(CheckCompletedSessionsDto::getSubjectCompletedAge).collect(Collectors.toList()).get(0);
        SubjectCompletedAge subjectCompletedAge4 = resultTest1.stream().filter(id -> id.getAnswerSessionId().equals(17L))
                .map(CheckCompletedSessionsDto::getSubjectCompletedAge).collect(Collectors.toList()).get(0);


        //Then
        assertEquals(SubjectCompletedAge.FRESH, subjectCompletedAge3);
        assertEquals(SubjectCompletedAge.OLD, subjectCompletedAge4);

        assertEquals(2, resultTest1.size());
        assertEquals(0, resultTest2.size());
        assertEquals(0, resultTest3.size());
        assertEquals(0, resultTest4.size());
        assertEquals(16L, resultTest1.get(0).getAnswerSessionId());
    }
}