package com.educator.core.question;

import com.educator.core.answer.AnswerDto;
import com.educator.core.answer.AnswerValidator;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.exception.CodeSageRuntimeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private static final int MAX_VALUE_ALL_ANSWERS = 10;
    private final QuestionMapper questionMapper;
    private final AnswerSessionRepository answerSessionRepository;
    private final QuestionRepository questionRepository;
    private final QuestionValidator questionValidator;
    private final AnswerValidator answerValidator;


    public List<QuestionDto> getAllQuestions() {
        return questionMapper.mapToListDtoQuestion(questionRepository.findAll());
    }

    public void createQuestion(QuestionDto questionDto) {
        questionValidator.validateDistinctQuestions(questionDto);
        answerValidator.validateDistinctAnswers(questionDto);
        answerValidator.validateAtLeastOneCorrectAnswer(questionDto);
        questionRepository.save(questionMapper.mapToQuestion(questionDto));
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    public List<QuestionDto> getQuestionsBySubjectId(Long subjectId) {
        return questionMapper.mapToListDtoQuestion(questionRepository.findBySubjectId(subjectId));
    }

    //ta metoda zwraca losowe pytanie z danego subject
    //ToDo nie używać słowa agular w backend
    public QuestionDto getQuestionFilterBySubject(Long answerSessionId) {
        AnswerSession answerSession = answerSessionRepository.getById(answerSessionId);
        Long subjectId = answerSession.getSubject().getId();

        List<QuestionDto> questionsSelect = questionMapper.mapToListDtoQuestion(questionRepository.findBySubjectId(subjectId));

        int answeredQuestion = answerSession.getAllAnswers();
        if (answeredQuestion < MAX_VALUE_ALL_ANSWERS) {
            return questionsSelect.get(answeredQuestion);
        } else {
            return null;
        }
    }

    public boolean hasQuestionsInSubject(Long subjectId) {
        if(subjectId == null) throw new CodeSageRuntimeException("Object is null");
        return questionRepository.countBySubjectId(subjectId) >= MAX_VALUE_ALL_ANSWERS;
    }

}
