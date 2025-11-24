package com.educator.core.question;
import com.educator.core.answer.AnswerDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class QuestionDto {

    private Long id;

    @NotNull
    private String displayName;

    @NotNull
    private Long subjectId;

    private List<AnswerDto> answers;

}
