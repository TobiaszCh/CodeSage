package com.educator.question;

import com.educator.answer.AnswerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestionDto {

    private Long id;
    private String displayName;
    private Long levelId;
    private List<AnswerDto> answers;

}
