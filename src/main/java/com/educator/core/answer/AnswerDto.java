package com.educator.core.answer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
public class AnswerDto {

    private  Long id;

    @NotNull
    private String displayName;

    private boolean isCorrect;

    @NotNull
    private Long questionId;

    @JsonIgnore
    public boolean isCorrect() {
        return isCorrect;
    }
}
