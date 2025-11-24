package com.educator.core.question;
import com.educator.core.answer.AnswerDto;
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
public class QuestionDto {

    private Long id;

    @NotBlank(message = "Pytanie nie może być puste")
    private String displayName;

    @NotNull
    private Long subjectId;

    @Valid
    private List<AnswerDto> answers;



}
