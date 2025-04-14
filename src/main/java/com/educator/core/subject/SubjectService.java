package com.educator.core.subject;

import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.subject.dto.CheckCompletedSessionsDto;
import com.educator.core.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private static final double BORDER_FINISHED_SUBJECT = 0.8;

    private final AuthService authService;

    private final SubjectRepository subjectRepository;

    private final AnswerSessionRepository answerSessionRepository;

    private final SubjectMapper subjectMapper;

    private final SubjectAgeService subjectAgeService;

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
        return getCheckCompletedSessionsDtos(subjectsIdFilterByCourseId, answerSessionsCompletedList);

    }

    private List<CheckCompletedSessionsDto> getCheckCompletedSessionsDtos(List<Long> subjectsIdFilterByCourseId, List<AnswerSession> answerSessionsCompletedList) {
        List<CheckCompletedSessionsDto> checkCompletedSessionsDtoList = new ArrayList<>();
        for (AnswerSession answerSessionCompleted : answerSessionsCompletedList) {
            double checkAllAndCorrectAnswers = getCheckAllAndCorrectAnswers(answerSessionCompleted);
            if (checkAllAndCorrectAnswers >= BORDER_FINISHED_SUBJECT && subjectsIdFilterByCourseId.contains(answerSessionCompleted.getSubject().getId())
                    && answerSessionCompleted.getUsers().getId().equals(authService.getLoggedUser().getId())) {
                SubjectCompletedAge resultCompletedAge = subjectAgeService.informAboutSubjectAge(answerSessionCompleted);
                checkCompletedSessionsDtoList.add(new CheckCompletedSessionsDto(answerSessionCompleted.getSubject().getId(), answerSessionCompleted.getId(), resultCompletedAge));
            }
        }
        return checkCompletedSessionsDtoList;
    }

    private double getCheckAllAndCorrectAnswers(AnswerSession answerSessionCompleted) {
        return answerSessionCompleted.getAllAnswers() == 0 ? 0 : (double) answerSessionCompleted.getCorrectAnswers() / answerSessionCompleted.getAllAnswers();
    }
}

