package com.educator.core.question;
import com.educator.core.answer_session.AnswerSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        return questionMapper.mapToDtoQuestion(questionRepository.findAllById(id));
    }
    //ta metoda zwraca losowe pytanie z danego subject
    public QuestionDto getQuestionFilterBySubjectIdFromAngular(Long answerSessionId) {
        Random randomQuestion = new Random();
        Long subjectId = answerSessionRepository.getById(answerSessionId).getSubject().getId();
        List<QuestionDto> questionsSelect = questionMapper.mapToListDtoQuestion(questionRepository.findAll()).stream()
                .filter(s -> s.getSubjectId().equals(subjectId)).collect(Collectors.toList());
        return questionsSelect.get(randomQuestion.nextInt(questionsSelect.size()));
    }
}
