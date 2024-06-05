package com.educator.core.answer_session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@Service
@RequiredArgsConstructor
public class AnswerSessionService {

    private final AnswerSessionRepository answerSessionRepository;

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
}
