package com.educator.core.subject;

import com.educator.auth.AuthService;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.QuestionService;
import com.educator.core.subject.dto.SubjectDetailsDto;
import com.educator.core.subject.dto.SubjectDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private static final double BORDER_FINISHED_SUBJECT = 0.8;
    private final AuthService authService;
    private final SubjectRepository subjectRepository;
    private final AnswerSessionRepository answerSessionRepository;
    private final SubjectMapper subjectMapper;
    private final QuestionService questionService;

    public Long createSubject(SubjectDto subjectDto) {
        subjectDto.setDisplayName(subjectDto.getDisplayName().trim());
        return subjectRepository.save(subjectMapper.mapToSubject(subjectDto)).getId();
    }

    public void deleteSubjectById(Long id) {
        subjectRepository.deleteById(id);
    }

    public List<SubjectDto> getSubjectsWithCompletionStatusByCourseId(Long courseId) {
        List<SubjectDto> subjectsDto = subjectRepository.findByCourseIdOrderByIdAsc(courseId);

        List<AnswerSession> answerSessionsCompletedList = answerSessionRepository
                .findByStatusAnswerSessionAndSubject_Course_IdAndUsersId(
                        StatusAnswerSession.COMPLETED,
                        courseId,
                        authService.getLoggedUser().getId());
        for (SubjectDto subjectDto: subjectsDto) {
            subjectDto.setSubjectCompletionStatus(getSubjectCompletionStatus(answerSessionsCompletedList, subjectDto.getId()));
        }
        return subjectsDto;
    }

    private SubjectCompletionStatus getSubjectCompletionStatus(List<AnswerSession> answerSessionsCompletedList, Long subjectId) {
        return answerSessionsCompletedList.stream()
                .filter(result -> calculateCorrectAnswerRatio(result) >= BORDER_FINISHED_SUBJECT
                        && result.getSubject().getId().equals(subjectId))
                .max(Comparator.comparing(AnswerSession::getSessionStartDate))
                .map(result -> result.getCompletionStatus(LocalDate.now()))
                .orElse(SubjectCompletionStatus.UNCOMPLETED);
    }

    private double calculateCorrectAnswerRatio(AnswerSession answerSessionCompleted) {
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

