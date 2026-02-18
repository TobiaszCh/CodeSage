package com.educator.core.question.dto;

import com.educator.core.answer.dto.AnswerWithoutCorrectDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QuestionWithoutAnswerCorrectDto {

    private Long id;

    @NotBlank(message = "Pytanie nie może być puste")
    private String displayName;

    @NotNull
    private Long subjectId;

    @Valid
    private List<AnswerWithoutCorrectDto> answers;

}
