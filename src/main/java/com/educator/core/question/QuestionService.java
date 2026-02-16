package com.educator.core.question;

import com.educator.core.answer.AnswerService;
import com.educator.core.answer.AnswerValidator;
import com.educator.core.answer_session.AnswerSession;
import com.educator.core.answer_session.AnswerSessionRepository;
import com.educator.core.exception.CodeSageRuntimeException;
import com.educator.core.question.dto.QuestionDto;
import com.educator.core.question.dto.QuestionWithoutAnswerCorrectDto;
import com.educator.core.subject.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private final AnswerService answerService;

    public List<QuestionDto> getAllQuestions() {
        return questionMapper.mapToListDtoQuestion(questionRepository.findAll());
    }

    @Transactional
    public Long createQuestions(List<QuestionDto> questionDto) {
        questionValidator.validateAllSubjectIdEquals(questionDto);
        questionValidator.validateDistinctQuestions(questionDto);
        questionDto.forEach((result) -> {
            answerValidator.validateDistinctAnswers(result);
            answerValidator.validateAtLeastOneCorrectAnswer(result);
        });
        questionRepository.saveAll(questionMapper.mapToListQuestion(questionDto));
        return subjectRepository.findCourseIdBySubjectId(questionDto.get(0).getSubjectId())
                .orElseThrow(() -> new CodeSageRuntimeException("In this subject courseId doesn't exist"));
    }

    @Transactional
    public Long updateQuestions(List<QuestionDto> questionDto) {
        questionValidator.validateAllSubjectIdEquals(questionDto);
        questionValidator.validateDistinctQuestions(questionDto);
        questionDto.forEach((result) -> {
            answerValidator.validateDistinctAnswers(result);
            updateQuestion(result);
        });
        return subjectRepository.findCourseIdBySubjectId(questionDto.get(0).getSubjectId())
                .orElseThrow(() -> new CodeSageRuntimeException("In this subject courseId doesn't exist"));
    }

    private void updateQuestion(QuestionDto questionDto) {
        Question question = questionRepository.findById(questionDto.getId()).orElseThrow(() -> new CodeSageRuntimeException("This question doesn't exist"));
        question.setDisplayName(questionDto.getDisplayName());
        questionDto.getAnswers().forEach(answerService::updateAnswer);
    }

    public List<QuestionDto> getQuestionsBySubjectId(Long subjectId) {
        return questionMapper.mapToListDtoQuestion(questionRepository.findBySubjectIdOrderByIdAsc(subjectId));
    }

    //ta metoda zwraca losowe pytanie z danego subject
    //ToDo nie używać słowa agular w backend
    public QuestionWithoutAnswerCorrectDto getQuestionFilterBySubject(Long answerSessionId) {
        AnswerSession answerSession = answerSessionRepository.getById(answerSessionId);
        Long subjectId = answerSession.getSubject().getId();
        List<QuestionWithoutAnswerCorrectDto> questionsSelect = questionMapper.mapToListDtoQuestionWithoutAnswerCorrect(questionRepository.findBySubjectIdOrderByIdAsc(subjectId));
        int answeredQuestion = answerSession.getAllAnswers();
        if (answeredQuestion < MAX_VALUE_ALL_QUESTIONS) {
            return questionsSelect.get(answeredQuestion);
        } else {
            return null;
        }
    }

    public boolean hasQuestionsInSubject(Long subjectId) {
        if (subjectId == null) throw new CodeSageRuntimeException("Object is null");
        return questionRepository.countBySubjectId(subjectId) == MAX_VALUE_ALL_QUESTIONS;
    }

}
