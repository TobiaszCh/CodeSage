package com.educator.core.answer;

import com.educator.core.answer.dto.AnswerDto;
import com.educator.core.answer.dto.AnswerWithoutCorrectDto;
import com.educator.core.exception.CodeSageRuntimeException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    private final AnswerMapper answerMapper;

    public List<AnswerWithoutCorrectDto> getAllAnswer() {
        return answerMapper.mapToListDtoAnswerWithoutCorrect(answerRepository.findAll());
    }

    public void deleteAnswer(Long id) {
        answerRepository.deleteById(id);
    }

    public void createAnswer(AnswerDto answerDto) {
        answerRepository.save(answerMapper.mapToAnswer(answerDto));
    }

    public void updateAnswer(AnswerDto answerDto) {
        Answer answer = answerRepository.findById(answerDto.getId()).orElseThrow(() -> new CodeSageRuntimeException("This answer doesn't exist"));
        answer.setDisplayName(answerDto.getDisplayName());
    }

}
