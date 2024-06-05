package com.educator.core.question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private Long subjectId;

    private int nextQuestionAndAnswers;

    private final QuestionMapper questionMapper;

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

    public void sendSubjectIdFromAngular(Long subjectId) {
        this.subjectId = subjectId;
    }

    //ta metoda zwraca losowe pytanie z danego subject
    public QuestionDto getQuestionFilterBySubjectIdFromAngular(String nextQuestion) {
        List<QuestionDto> questionsSelect = questionMapper.mapToListDtoQuestion(questionRepository.findAll()).stream()
                .filter(s -> s.getSubjectId().equals(subjectId)).collect(Collectors.toList());
        if (nextQuestion.equals("nextQuestion") && nextQuestionAndAnswers < questionsSelect.size() - 1) {
            nextQuestionAndAnswers++;
        }
        else if (!nextQuestion.equals("nextQuestion")){
            nextQuestionAndAnswers = 0;
        }
        return questionsSelect.get(nextQuestionAndAnswers);
    }
}
