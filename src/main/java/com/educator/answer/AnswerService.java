package com.educator.answer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerMapper answerMapper;

    public List<AnswerDto> getAllAnswer () {
        return answerMapper.mapToListDtoAnswer(answerRepository.findAll());
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    public void createAnswer(AnswerDto answerDto) {
        answerRepository.save(answerMapper.mapToAnswer(answerDto));
    }


}
