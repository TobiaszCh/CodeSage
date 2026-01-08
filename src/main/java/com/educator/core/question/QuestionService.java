package com.educator.core.question;

import com.educator.core.answer.AnswerValidator;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.course.CourseRepository;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private static final int MAX_VALUE_ALL_QUESTIONS = 10;
    private final QuestionMapper questionMapper;
    private final AnswerSessionRepository answerSessionRepository;
    private final QuestionRepository questionRepository;
    private final QuestionValidator questionValidator;
    private final AnswerValidator answerValidator;
    private final SubjectRepository subjectRepository;


    public List<QuestionDto> getAllQuestions() {
        return questionMapper.mapToListDtoQuestion(questionRepository.findAll());
    }

    public Long createQuestions(List<QuestionDto> questionDto) {
        answerValidator.validateAllSubjectIdEquals(questionDto);
        questionDto.forEach((result) -> {
            questionValidator.validateDistinctQuestions(result);
            answerValidator.validateDistinctAnswers(result);
            answerValidator.validateAtLeastOneCorrectAnswer(result);
        });
        questionRepository.saveAll(questionMapper.mapToListQuestion(questionDto));
        return subjectRepository.findCourseIdBySubjectId(questionDto.get(0).getSubjectId());
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
        if (answeredQuestion < MAX_VALUE_ALL_QUESTIONS) {
            return questionsSelect.get(answeredQuestion);
        } else {
            return null;
        }
    }

    public boolean hasQuestionsInSubject(Long subjectId) {
        if(subjectId == null) throw new CodeSageRuntimeException("Object is null");
        return questionRepository.countBySubjectId(subjectId) == MAX_VALUE_ALL_QUESTIONS;
    }

}
