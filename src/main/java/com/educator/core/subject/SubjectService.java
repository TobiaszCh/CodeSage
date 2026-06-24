package com.educator.core.subject;

import com.educator.aspect.EntityType;
import com.educator.aspect.ModificationAccess;
import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.QuestionService;
import com.educator.core.subject.dto.SubjectCompletionStatusDto;
import com.educator.core.subject.dto.SubjectDetailsDto;
import com.educator.core.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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

    private final QuestionService questionService;

    @ModificationAccess(objectType = EntityType.COURSE, idExpression = "#subjectDto.courseId")
    public Long createSubject(SubjectDto subjectDto) {
        subjectDto.setDisplayName(subjectDto.getDisplayName().trim());
        return subjectRepository.save(subjectMapper.mapToSubject(subjectDto)).getId();
    }

    @ModificationAccess(objectType = EntityType.SUBJECT, idExpression = "#id")
    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }

    public List<SubjectDto> getSubjectsFilterByCourseId(Long courseId) {
        return subjectMapper.mapToDtoSubjectList(subjectRepository.findByCourseIdOrderByIdAsc(courseId));
    }

    public List<SubjectCompletionStatusDto> getAllNumbersOfCorrectAnswersAtLeast80Percent(Long courseId) {
        List<Long> subjectsIdFilterByCourseId = subjectRepository.findByCourseIdOrderByIdAsc(courseId).stream().map(Subject::getId).collect(Collectors.toList());
        List<AnswerSession> answerSessionsCompletedList = answerSessionRepository.findByStatusAnswerSession(StatusAnswerSession.COMPLETED);
        return getCheckCompletedSessions(subjectsIdFilterByCourseId, answerSessionsCompletedList);

    }

    private List<SubjectCompletionStatusDto> getCheckCompletedSessions(List<Long> subjectsIdFilterByCourseId, List<AnswerSession> answerSessionsCompletedList) {
        List<SubjectCompletionStatusDto> subjectCompletionStatusDtoList = new ArrayList<>();
        for (AnswerSession answerSessionCompleted : answerSessionsCompletedList) {
            double checkAllAndCorrectAnswers = getCheckAllAndCorrectAnswers(answerSessionCompleted);
            if (checkAllAndCorrectAnswers >= BORDER_FINISHED_SUBJECT && subjectsIdFilterByCourseId.contains(answerSessionCompleted.getSubject().getId())
                    && answerSessionCompleted.getUsers().getId().equals(authService.getLoggedUser().getId())) {
                SubjectCompletedAge resultCompletedAge = answerSessionCompleted.getCompletedAge(LocalDate.now());
                subjectCompletionStatusDtoList.add(new SubjectCompletionStatusDto(answerSessionCompleted.getSubject().getId(), answerSessionCompleted.getId(), resultCompletedAge));
            }
        }
        return subjectCompletionStatusDtoList;
    }

    private double getCheckAllAndCorrectAnswers(AnswerSession answerSessionCompleted) {
        return answerSessionCompleted.getAllAnswers() == 0 ? 0 : (double) answerSessionCompleted.getCorrectAnswers() / answerSessionCompleted.getAllAnswers();
    }

    public Long getCourseId(Long id) {
        if (id == null) {
            throw new CodeSageRuntimeException("Id is null");
        }
        return subjectRepository.findCourseIdBySubjectId(id).orElseThrow(
                () -> new CodeSageRuntimeException("In this subject courseId doesn't exist"));
    }

    public SubjectDto getSubjectById(Long id) {
        return subjectMapper.mapToDtoSubject(subjectRepository.findById(id).orElseThrow(
                () -> new CodeSageRuntimeException("This subject doesn't exist")));
    }

    @Transactional
    @ModificationAccess(objectType = EntityType.SUBJECT, idExpression = "#id")
    public Long updateSubjectDetails(Long id, SubjectDetailsDto subjectDetailsDto) {
        Subject updateSubject = subjectRepository.findById(id).orElseThrow(
                () -> new CodeSageRuntimeException("This subject doesn't exist"));
        if (subjectDetailsDto == null) {
            throw new CodeSageRuntimeException("SubjectDetailsDto is null");
        }
        updateSubject.setDisplayName(subjectDetailsDto.getDisplayName().trim());
        return questionService.updateQuestions(id, subjectDetailsDto.getQuestions());
    }
}

