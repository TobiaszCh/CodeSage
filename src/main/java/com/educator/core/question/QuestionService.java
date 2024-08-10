package com.educator.core.question;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionMapper questionMapper;
    private final AnswerSessionRepository answerSessionRepository;
    private final QuestionRepository questionRepository;


    public List<QuestionDto> getAllQuestions () {
        return questionMapper.mapToListDtoQuestion(questionRepository.findAll());
    }

    public void createQuestion(QuestionDto questionDto) {
        questionRepository.save(questionMapper.mapToQuestion(questionDto));
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public QuestionDto getQuestionById(Long id) {
        return questionMapper.mapToDtoQuestion(questionRepository.getById(id));
    }
    //ta metoda zwraca losowe pytanie z danego subject
    //ToDo nie używać słowa agular w backend
    public QuestionDto getQuestionFilterBySubject(Long answerSessionId) {
        AnswerSession answerSession = answerSessionRepository.getById(answerSessionId);
        Long subjectId = answerSession.getSubject().getId();

        List<QuestionDto> questionsSelect = questionMapper.mapToListDtoQuestion(questionRepository.findBySubjectId(subjectId));

        int answeredQuestion = answerSession.getAllAnswers();
        if(answeredQuestion < 10) {
            return questionsSelect.get(answeredQuestion);
        }
        else {
            return null;
        }
    }
}
