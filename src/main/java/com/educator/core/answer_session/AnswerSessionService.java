package com.educator.core.answer_session;

import com.educator.auth.AuthService;
import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import com.educator.core.answer_session.dto.SubjectIdToAnswerSessionDto;
import com.educator.core.answer_session.enums.StatusAnswerSession;
import com.educator.core.question.QuestionRepository;
import com.educator.core.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AnswerSessionService {

    private static final int POINT_FOR_GOOD_ANSWER = 1;

    private static final int POINT_FOR_ANSWER = 1;

    private static final int MAX_VALUE_ALL_ANSWERS = 10;

    private final AuthService authService;

    private final AnswerSessionRepository answerSessionRepository;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    private final AnswerSessionMapper answerSessionMapper;

    private final SubjectRepository subjectRepository;


    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionMapper.mapToListDtoAnswerSession(answerSessionRepository.findAll());
    }

    public Long sendSubjectIdToNewAnswerSession(SubjectIdToAnswerSessionDto subjectIdToAnswerSessionDto) {
        AnswerSession answerSession = answerSessionRepository
                .save(answerSessionMapper.mapToAnswerSession(subjectRepository.getById(subjectIdToAnswerSessionDto.getId()), authService.getLoggedUser(), StatusAnswerSession.IN_PROGRESS));
        return answerSessionMapper.mapToDtoAnswerSession(answerSession).getId();
    }

    public void deleteById(Long id) {
        answerSessionRepository.deleteById(id);
    }

    public Long selectQuestionAnswer(Long id, QuestionAnswerSelectDto questionAnswerSelectDto) {
            AnswerSession answerSessionUpdate = answerSessionRepository.getById(id);
            boolean correctAnswer = answerRepository.getById(questionAnswerSelectDto.getAnswerId()).isCorrect();
            changeAllAndCorrectAnswers(answerSessionUpdate, correctAnswer);
            answerSessionRepository.save(answerSessionUpdate);
            return questionRepository.getById(questionAnswerSelectDto.getQuestionId()).getAnswers()
                    .stream().filter(Answer::isCorrect).mapToLong(Answer::getId).sum();
    }

    private static void changeAllAndCorrectAnswers(AnswerSession answerSessionUpdate, boolean correctAnswer) {
        answerSessionUpdate.setAllAnswers(answerSessionUpdate.getAllAnswers() + POINT_FOR_ANSWER);
        if (correctAnswer) {
            answerSessionUpdate.setCorrectAnswers(answerSessionUpdate.getCorrectAnswers() + POINT_FOR_GOOD_ANSWER);
        }
    }

    public void updateAnswerSessionStatus(Long id) {
            AnswerSession answerSession = answerSessionRepository.getById(id);
            changeStatus(answerSession);
            answerSessionRepository.save(answerSession);
    }

    private static void changeStatus(AnswerSession answerSession) {
        if (answerSession.getAllAnswers() == MAX_VALUE_ALL_ANSWERS) {
            answerSession.setStatusAnswerSession(StatusAnswerSession.COMPLETED);
        } else {
            answerSession.setStatusAnswerSession(StatusAnswerSession.ABANDONED);
        }
    }

}
