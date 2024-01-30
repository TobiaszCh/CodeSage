package com.educator.answer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private Long id;

    private String displayName;

    private Long questionId;
}
