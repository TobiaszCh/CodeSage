package com.educator.core.answer_session;

import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.dto.AnswerSessionStatusIdDto;
import com.educator.core.answer_session.dto.CheckCompletedSessionsDto;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.answer_session.enums.SubjectColor;
import com.educator.core.question.QuestionRepository;
import com.educator.core.subject.Subject;
import com.educator.core.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AnswerSessionService {

    private final AnswerSessionRepository answerSessionRepository;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    private final AnswerSessionMapper answerSessionMapper;

    private final SubjectRepository subjectRepository;

    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionMapper.mapToListDtoAnswerSession(answerSessionRepository.findAll());
    }

    public Long sendSubjectIdToAnswerSession(AnswerSessionDto answerSessionDto) {
        AnswerSession answerSession = answerSessionRepository.save(answerSessionMapper.mapToAnswerSession(answerSessionDto));
        return answerSession.getId();
    }

    public void deleteById(Long id) {
        answerSessionRepository.deleteById(id);
    }

    public Long selectQuestionAnswer(Long id, QuestionAnswerSelectDto questionAnswerSelectDto) {
        if (questionAnswerSelectDto.getAnswerId() != null) {
            AnswerSession answerSessionUpdate = answerSessionRepository.getById(id);
            answerSessionUpdate.setAllAnswers(answerSessionUpdate.getAllAnswers() + 1);
            if (answerRepository.getById(questionAnswerSelectDto.getAnswerId()).isCorrect()) {
                answerSessionUpdate.setCorrectAnswers(answerSessionUpdate.getCorrectAnswers() + 1);
            }
            answerSessionRepository.save(answerSessionUpdate);
        }
        return questionRepository.getById(questionAnswerSelectDto.getQuestionId()).getAnswers()
                .stream().filter(Answer::isCorrect).mapToLong(Answer::getId).sum();

    }

    public void updateAnswerSessionStatus(Long id, AnswerSessionStatusIdDto answerSessionStatusIdDto) {
        AnswerSession answerSession = answerSessionRepository.getById(answerSessionStatusIdDto.getId());
        if (answerSession.getAllAnswers() == 10) {
            answerSession.setStatusAnswerSession(StatusAnswerSession.COMPLETED);
        } else {
            answerSession.setStatusAnswerSession(StatusAnswerSession.ABANDONED);
        }
        answerSessionRepository.save(answerSession);
    }

    public List<CheckCompletedSessionsDto> getAllNumbersOfCorrectAnswersAtLeast80Percent(Long courseId) {
        List<Long> subjectsIdFilterByCourseId = subjectRepository.findByCourseId(courseId).stream().map(Subject::getId).collect(Collectors.toList());
        List<AnswerSession> answerSessionsCompletedList = answerSessionRepository.findByStatusAnswerSession(StatusAnswerSession.COMPLETED);
        return getCheckCompletedSessionsDtos(subjectsIdFilterByCourseId, answerSessionsCompletedList);

    }

    private static List<CheckCompletedSessionsDto> getCheckCompletedSessionsDtos(List<Long> subjectsIdFilterByCourseId, List<AnswerSession> answerSessionsCompletedList) {
        List<CheckCompletedSessionsDto> checkCompletedSessionsDtoList = new ArrayList<>();
        long differenceInDaysBetweenTheStartedSessionAndToday;
        for (AnswerSession answerSessionCompleted : answerSessionsCompletedList) {
            double checkAllAndCorrectAnswers = (double) answerSessionCompleted.getCorrectAnswers() / answerSessionCompleted.getAllAnswers();
            if (checkAllAndCorrectAnswers >= 0.8 && subjectsIdFilterByCourseId.contains(answerSessionCompleted.getSubject().getId())) {
                differenceInDaysBetweenTheStartedSessionAndToday = ChronoUnit.DAYS.between(answerSessionCompleted.getSessionStartDate(), LocalDate.now());
                if (differenceInDaysBetweenTheStartedSessionAndToday <= 7) {
                    checkCompletedSessionsDtoList.add(new CheckCompletedSessionsDto(answerSessionCompleted.getId(), answerSessionCompleted.getSubject().getId(), SubjectColor.GREEN));
                } else {
                    checkCompletedSessionsDtoList.add(new CheckCompletedSessionsDto(answerSessionCompleted.getId(), answerSessionCompleted.getSubject().getId(), SubjectColor.YELLOW));
                }
            }
        }
        return checkCompletedSessionsDtoList;
    }

}
