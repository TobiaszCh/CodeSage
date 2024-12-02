package com.educator.core.subject;
import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.dto.CheckCompletedSessionsDto;
import com.educator.core.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private static final double BORDER_FINISHED_SUBJECT = 0.8;

    private static final int BORDER_SEVEN_DAYS = 7;

    private final AuthService authService;

    private final SubjectRepository subjectRepository;

    private final AnswerSessionRepository answerSessionRepository;

    private final SubjectMapper subjectMapper;
  
    public List<SubjectDto> getAllSubjects() {
        return subjectMapper.mapToDtoSubjectList(subjectRepository.findAll());
    }

    public void createSubject(SubjectDto subjectDto) {
        subjectRepository.save(subjectMapper.mapToSubject(subjectDto));
    }

    public void deleteCourse(Long id) {
        subjectRepository.deleteById(id);
    }

    public void deleteAllCourse() {
        subjectRepository.deleteAll();
    }

    public List<SubjectDto> getSubjectsFilterByCourseId(Long courseId) {
        return subjectMapper.mapToDtoSubjectList(subjectRepository.findAll()).stream()
                .filter(i -> i.getCourseId().equals(courseId)).collect(Collectors.toList());
    }

    public List<CheckCompletedSessionsDto> getAllNumbersOfCorrectAnswersAtLeast80Percent(Long courseId) {
        List<Long> subjectsIdFilterByCourseId = subjectRepository.findByCourseId(courseId).stream().map(Subject::getId).collect(Collectors.toList());
        List<AnswerSession> answerSessionsCompletedList = answerSessionRepository.findByStatusAnswerSession(StatusAnswerSession.COMPLETED);
        return getCheckCompletedSessionsDtos(subjectsIdFilterByCourseId, answerSessionsCompletedList, authService);

    }

    private static List<CheckCompletedSessionsDto> getCheckCompletedSessionsDtos(List<Long> subjectsIdFilterByCourseId, List<AnswerSession> answerSessionsCompletedList, AuthService authService) {
        List<CheckCompletedSessionsDto> checkCompletedSessionsDtoList = new ArrayList<>();
        for (AnswerSession answerSessionCompleted : answerSessionsCompletedList) {
            double checkAllAndCorrectAnswers = getCheckAllAndCorrectAnswers(answerSessionCompleted);
            if (checkAllAndCorrectAnswers >= BORDER_FINISHED_SUBJECT && subjectsIdFilterByCourseId.contains(answerSessionCompleted.getSubject().getId())
            && answerSessionCompleted.getUsers().getId().equals(authService.getLoggedUser().getId())) {
                if (getDifferenceInDaysBetweenTheStartedSessionAndToday(answerSessionCompleted) <= BORDER_SEVEN_DAYS) {
                    checkCompletedSessionsDtoList.add(new CheckCompletedSessionsDto(answerSessionCompleted.getSubject().getId(),answerSessionCompleted.getId(), SubjectColor.TO_SEVEN_DAYS));
                } else {
                    checkCompletedSessionsDtoList.add(new CheckCompletedSessionsDto(answerSessionCompleted.getSubject().getId(),answerSessionCompleted.getId(), SubjectColor.AFTER_SEVEN_DAYS));
                }
            }
        }
        return checkCompletedSessionsDtoList;
    }

    private static double getCheckAllAndCorrectAnswers(AnswerSession answerSessionCompleted) {
        return answerSessionCompleted.getAllAnswers() == 0 ? 0: (double) answerSessionCompleted.getCorrectAnswers() / answerSessionCompleted.getAllAnswers();
    }

    private static long getDifferenceInDaysBetweenTheStartedSessionAndToday(AnswerSession answerSessionCompleted) {
        long differenceInDaysBetweenTheStartedSessionAndToday;
        differenceInDaysBetweenTheStartedSessionAndToday = ChronoUnit.DAYS.between(answerSessionCompleted.getSessionStartDate(), LocalDate.now());
        return differenceInDaysBetweenTheStartedSessionAndToday;
    }
}

