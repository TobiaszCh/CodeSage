package com.educator.question;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

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
}
