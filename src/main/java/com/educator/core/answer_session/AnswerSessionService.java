package com.educator.core.answer_session;
import com.educator.core.answer.Answer;
import com.educator.core.answer.AnswerRepository;
import com.educator.core.answer_session.dto.AnswerSessionDto;
import com.educator.core.answer_session.dto.AnswerSessionStatusIdDto;
import com.educator.core.answer_session.dto.QuestionAnswerSelectDto;
import com.educator.core.question.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AnswerSessionService {

    private final AnswerSessionRepository answerSessionRepository;

    private final QuestionRepository questionRepository;

    private final AnswerRepository answerRepository;

    private final AnswerSessionMapper answerSessionMapper;

    public List<AnswerSessionDto> getAllAnswer() {
        return answerSessionMapper.mapToListDtoAnswerSession(answerSessionRepository.findAll());
    }

    public Long sendSubjectIdToAnswerSession(@RequestBody AnswerSessionDto answerSessionDto) {
        AnswerSession answerSession = answerSessionRepository.save(answerSessionMapper.mapToAnswerSession(answerSessionDto));
        return answerSession.getId();
    }

    public void deleteById(Long id) {
        answerSessionRepository.deleteById(id);
    }

    public Long selectQuestionAnswer(Long id, QuestionAnswerSelectDto questionAnswerSelectDto) {
        if(questionAnswerSelectDto.getAnswerId() != null) {
            AnswerSession answerSessionUpdate = answerSessionRepository.getById(id);
            answerSessionUpdate.setAllAnswers(answerSessionUpdate.getAllAnswers() + 1);
            if(answerRepository.getById(questionAnswerSelectDto.getAnswerId()).isCorrect()) {
                answerSessionUpdate.setCorrectAnswers(answerSessionUpdate.getCorrectAnswers() + 1);
            }
            answerSessionRepository.save(answerSessionUpdate);
        }
        return questionRepository.getById(questionAnswerSelectDto.getQuestionId()).getAnswers()
                .stream().filter(Answer::isCorrect).mapToLong(Answer::getId).sum();

    }

    public void updateAnswerSessionStatus(Long id, AnswerSessionStatusIdDto answerSessionStatusIdDto) {
        AnswerSession answerSession = answerSessionRepository.getById(answerSessionStatusIdDto.getId());
        if(answerSession.getAllAnswers() == 10) {
            answerSession.setStatusAnswerSession(StatusAnswerSession.COMPLETED);
        }
        else {
            answerSession.setStatusAnswerSession(StatusAnswerSession.ABANDONED);
        }
        answerSessionRepository.save(answerSession);
    }

}
