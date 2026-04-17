package com.educator.core.subject.dto;

import com.educator.core.question.dto.QuestionDto;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class SubjectDetailsDto {

    @Size(max = 50)
    @NotBlank(message = "Temat nie może być pusty")
    private String displayName;

    @Valid
    private List<QuestionDto> questions;

}
