package com.educator.core.question.dto;

import lombok.Getter;
import javax.validation.Valid;
import java.util.List;

@Getter
public class QuestionsDto {

    private List<@Valid QuestionDto> questions;

}
